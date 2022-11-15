package com.wyhw.pmp.util;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 文件工具类
 * @author wanyanhw
 */
public class FileUtil {


    private static final String SPLIT_FILE_SUFFIX = "&&";

    /**
     * 保存文件到指定路径
     * @param path 文件路径
     * @param fileName 文件名
     * @param inputStream 文件字节
     * @return true-成功 false-失败
     * @throws IOException 异常
     */
    public static boolean saveFile(String path, String fileName, InputStream inputStream) throws IOException {
        File dir = new File(path);
        if (!dir.exists()) {
            // 目标不存在则新建目录
            dir.mkdirs();
        }
        File file = new File(path + File.separator + fileName);
        // 文件分片大小 100M
        int fileSizeThreshold = 100 * 1024 * 1024;
        if (inputStream.available() <= fileSizeThreshold) {
            try (FileOutputStream fos = new FileOutputStream(file);
                 BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                byte[] buffer = new byte[2 * 1024 * 1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    bos.write(buffer, 0, len);
                }
                return true;
            }
        } else {
            List<File> splitBySize = splitBySize(inputStream, fileSizeThreshold, file.getName(), path);
            new Thread(() -> {
                try {
                    merge(splitBySize, path, file.getName());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            return true;
        }
    }

    /**
     * 合并文件
     * 注意：合并文件时需按分片顺序从小到大合并
     * @param fileDirectory 文件目录
     * @param fileName 文件名称
     * @param separator 分片文件分隔符号，符号前为文件名称（无类型），符号后为分片序号
     * @param chunkTotal 总分片数
     * @return true-合并成功 false-合并失败
     * @throws IOException 异常
     */
    @Deprecated
    public static boolean mergeFile(String fileDirectory, String fileName, String separator, int chunkTotal) throws IOException {
        File dir = new File(fileDirectory);
        boolean isDirectory = dir.isDirectory();
        if (!isDirectory) {
            return false;
        }
        String[] fileArguments = fileName.split(SPLIT_FILE_SUFFIX);
        if (fileArguments.length != 2) {
            return false;
        }
        String targetFileName = fileArguments[0];
        String targetFileType = fileArguments[1];

        File[] files = dir.listFiles();
        if (files == null) {
            return false;
        }

        File targetFile = new File(fileDirectory + File.separator + fileName);
        try (FileOutputStream fos = new FileOutputStream(targetFile);
             BufferedOutputStream os = new BufferedOutputStream(fos)) {
            byte[] bytes = new byte[2 * 1024 * 1024];
            int chunkIndex = 1;
            for (File splitFile : files) {
                if (splitFile.isDirectory()) {
                    continue;
                }
                String tempFileName = splitFile.getName();
                String[] tempFileArguments = tempFileName.split(SPLIT_FILE_SUFFIX);
                String[] tempName = tempFileArguments[0].split(separator);
                if (tempName.length != 2) {
                    continue;
                }
                String type = tempFileArguments[1];
                String name = tempName[0];
                int index = Integer.parseInt(tempName[1]);
                boolean match = targetFileName.equals(name) && targetFileType.equals(type) && index == chunkIndex;
                if (!match) {
                    continue;
                }
                try (FileInputStream fis = new FileInputStream(splitFile)) {
                    int count;
                    while ((count = fis.read(bytes)) != -1) {
                        os.write(bytes, 0, count);
                    }
                    splitFile.delete();
                    chunkIndex ++;
                }

                if (chunkIndex > chunkTotal) {
                    break;
                }
            }
            return true;
        }
    }

    /**
     * Split a large file into {@code total} mini-files
     *
     * @param file The large source source
     * @param total The number of the mini-files. If the large source file {@code file} can not be completely divided into
     *              {@code total} mini-files, the value of the {@code total} will increase one
     * @param filename The mini-files prefix name. These names will be all ended with special format like, @eg: "***.1, ***.2, ***.3"
     * @param basePath The file path which the mini-files will be stored in
     * @return The sorted array of mini-files. The suffix number of the mini-file is smaller, the index of the mini-files array is smaller
     */
    public static List<File> splitByQuantity(File file, int total, String filename, String basePath) throws IOException{
        long subFileSize = file.length() / total;
        long size = file.length() % total > 0 ? subFileSize + 1 : subFileSize;
        return splitBySize(file, (int) (size), filename, basePath);
    }

    /**
     * Split a large file into {@code total} mini-files
     *
     * @param file The large source source
     * @param size The max byte size of the mini file. If the large source file {@code file} can not be completely divided by
     *              {@code size}, the number of the mini-files will increase one
     * @param filename The mini-files prefix name. These names will be all ended with special format like, @eg: "***.1, ***.2, ***.3"
     * @param basePath The file path which the mini-files will be stored in
     * @return The sorted array of mini-files. The suffix number of the mini-file is smaller, the index of the mini-files array is smaller
     */
    private static List<File> splitBySize(File file, int size, String filename, String basePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            return splitBySize(fis, size, filename, basePath);
        }
    }

    private static List<File> splitBySize(InputStream inputStream, int size, String filename, String basePath) throws IOException {
        int splitIndex = 0;
        List<File> splitFiles = new ArrayList<>();
        byte[] buffer = new byte[size];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            try(ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                bos.write(buffer, 0, length);
                File file = new File(basePath + File.separator + filename + SPLIT_FILE_SUFFIX + (splitIndex + 1));
                splitFiles.add(file);
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    fos.write(bos.toByteArray());
                }
                splitIndex++;
            }
        }
        return splitFiles;
    }

    /**
     * merge some split mini-files a large file
     *
     * @param files The mini file array.
     * @param path The large target file will be stored in
     * @param filename Name the large target file
     */
    public static boolean merge(List<File> files, String path, String filename) throws IOException {
        List<File> fileList = filenameFilter(files, filename);
        if (fileList.isEmpty()) {
            return false;
        }

        fileList.sort((o1, o2) -> {
            Integer index1 = Integer.valueOf(o1.getName().split(SPLIT_FILE_SUFFIX)[1]);
            Integer index2 = Integer.valueOf(o2.getName().split(SPLIT_FILE_SUFFIX)[1]);
            return index1.compareTo(index2);
        });

        try (FileOutputStream fos = new FileOutputStream(new File(path + File.separator + filename))) {
            for (File file : fileList) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    byte[] b = new byte[50 * 1024 * 1024];
                    int length;
                    while ((length = fis.read(b)) != -1) {
                        fos.write(b, 0, length);
                    }
                }
                file.delete();
            }
            return true;
        }
    }

    /**
     * 按照文件名称过滤文件数组
     * @param files 文件数组
     * @param filename 指定文件名称
     * @return List 过滤后的文件列表
     */
    private static List<File> filenameFilter(List<File> files, String filename) {
        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            String subFilename = file.getName();
            String[] split = subFilename.split(SPLIT_FILE_SUFFIX);
            String extension = split[split.length - 1];
            try {
                // 扩展名不是数字的情况下，可判断此文件不是分片文件
                Integer.valueOf(extension);
            } catch (Exception e) {
                continue;
            }
            if (subFilename.contains(filename)) {
                fileList.add(file);
            }
        }
        return fileList;
    }

    /**
     * 输入流转字节数组
     * @param inputStream 输入流
     * @return byte[] 字节数组
     * @throws IOException 异常
     */
    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(inputStream);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            int len;
            byte[] buffer = new byte[2048];
            while ((len = bis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            return baos.toByteArray();
        }
    }

    /**
     * 文件转移
     * @param from 原文件地址
     * @param to 目的地址
     * @param deleteOriginalFile 是否删除源文件
     * @param ignoreEmptyFolderCreation 是否忽略创建空文件夹，若 true, 则不创建内部空文件夹；否则即使为空依然创建
     */
    public static void moveTo(String from, String to, boolean deleteOriginalFile, boolean ignoreEmptyFolderCreation) {
        File fromFile = new File(from);
        boolean directory = fromFile.isDirectory();
        if (directory) {
            String[] pathNames = fromFile.list();
            if (pathNames == null || pathNames.length == 0) {
                if (!ignoreEmptyFolderCreation) {
                    new File(to).mkdir();
                }
                return;
            } else {
                new File(to).mkdirs();
            }
            Arrays.stream(pathNames).parallel().forEach(subPath -> {
                File subFile = new File(from + File.separator + subPath);
                if (subFile.isDirectory()) {
                    moveTo(from + File.separator + subPath, to + File.separator + subPath, deleteOriginalFile, ignoreEmptyFolderCreation);
                } else {
                    transferFileFromChannel(from + File.separator + subPath, to + File.separator + subFile.getName());
//                    saveFile(to, subFile, deleteOriginalFile);
                }
            });
            if (deleteOriginalFile) {
                fromFile.delete();
            }
            return;
        }
        transferFileFromChannel(from, to + File.separator + fromFile.getName());
//        saveFile(to, fromFile, deleteOriginalFile);
    }

    private static void transferFileFromChannel(String from, String to) {
        try {
            RandomAccessFile fromAccess = new RandomAccessFile(from, "rw");
            FileChannel fromChannel = fromAccess.getChannel();

            RandomAccessFile toAccess = new RandomAccessFile(to, "rw");
            FileChannel toChannel = toAccess.getChannel();

            toChannel.transferFrom(fromChannel, 0L, fromChannel.size());
            fromChannel.close();
            toChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    private static void saveFile(String to, File fromFile, boolean deleteOriginalFile) {
        try (InputStream inputStream = new FileInputStream(fromFile)) {
            saveFile(to, fromFile.getName(), inputStream);
            StringBuilder infoBuilder = new StringBuilder();
            infoBuilder.append(fromFile.getName())
                    .append(" 文件已保存至: ")
                    .append(to)
                    .append(File.separator)
                    .append(fromFile.getName());
            if (deleteOriginalFile) {
                boolean delete = fromFile.delete();
                if (delete) {
                    infoBuilder.append(", 源文件已删除！");
                }
            }
            System.out.println(infoBuilder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
//        String from = "E:\\BaiduNetdiskDownload\\Photoshop 2020 v21.0.2.57\\products\\CCXP\\CCX-Process-mul.zip";
        String from = "E:\\BaiduNetdiskDownload\\";
//        String from = "E:\\BaiduNetdiskDownload\\PS2022(64bit).rar";
//        String from = "E:\\BaiduNetdiskDownload\\InDesign2022(64bit).rar";
        String to = "D:\\wyhw\\backup";
        moveTo(from, to, false, false);
        long end = System.currentTimeMillis();
        System.out.println("cost time: " + (end - begin) + "ms");

        Thread.sleep(300 * 1000);
    }
}
