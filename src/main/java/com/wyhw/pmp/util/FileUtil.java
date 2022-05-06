package com.wyhw.pmp.util;

import java.io.*;

/**
 * 文件工具类
 * @author wanyanhw
 */
public class FileUtil {


    /**
     * 保存文件到指定路径
     * @param path 文件路径
     * @param fileName 文件名
     * @param bytes 文件字节
     * @return true-成功 false-失败
     * @throws IOException 异常
     */
    public static boolean saveFile(String path, String fileName, byte[] bytes) throws IOException {
        File dir = new File(path);
        if (!dir.isDirectory()) {
            // 目标不存在则新建目录
            dir.mkdirs();
        }
        File file = new File(path + File.separator + fileName);
        try (FileOutputStream fos = new FileOutputStream(file);
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            bos.write(bytes);
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
    public static boolean mergeFile(String fileDirectory, String fileName, String separator, int chunkTotal) throws IOException {
        File dir = new File(fileDirectory);
        boolean isDirectory = dir.isDirectory();
        if (!isDirectory) {
            return false;
        }
        String[] fileArguments = fileName.split("\\.");
        if (fileArguments.length != 2) {
            return false;
        }
        String targetName = fileArguments[0];
        String targetType = fileArguments[1];

        File[] files = dir.listFiles();
        if (files == null) {
            return false;
        }

        File targetFile = new File(fileDirectory + File.separator + fileName);
        try (FileOutputStream fos = new FileOutputStream(targetFile);
             BufferedOutputStream os = new BufferedOutputStream(fos)) {
            byte[] bytes = new byte[1024 * 1024 * 2];
            int chunkIndex = 1;
            for (File file : files) {
                if (file.isDirectory()) {
                    continue;
                }
                String tempFileName = file.getName();
                String[] tempFileArguments = tempFileName.split("\\.");
                String[] tempName = tempFileArguments[0].split(separator);
                if (tempName.length != 2) {
                    continue;
                }
                String type = tempFileArguments[1];
                String name = tempName[0];
                int index = Integer.parseInt(tempName[1]);
                boolean match = targetName.equals(name) && targetType.equals(type) && index == chunkIndex;
                if (!match) {
                    continue;
                }
                try (FileInputStream fis = new FileInputStream(file)) {
                    int count;
                    while ((count = fis.read(bytes)) != -1) {
                        os.write(bytes, 0, count);
                    }
                    file.delete();
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
    public static File[] splitByQuantity(File file, int total, String filename, String basePath) throws IOException{
        return splitBySize(file, (int) (file.length() / total), filename, basePath);
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
    private static File[] splitBySize(File file, int size, String filename, String basePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            int splitIndex = 0;
            int splitTotal = (int) (file.length() % size > 0 ? file.length() / size + 1 : file.length() / size);
            File[] splitFiles = new File[splitTotal];
            byte[] b = new byte[size];
            int length;
            while ((length = fis.read(b, 0, b.length)) != -1) {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bos.write(b, 0, length);
                splitFiles[splitIndex] = new File(basePath + filename + "." + (splitIndex + 1));
                try (FileOutputStream fos = new FileOutputStream(splitFiles[splitIndex])) {
                    fos.write(bos.toByteArray());
                }
                bos.close();
                splitIndex ++;
            }
            return splitFiles;
        }
    }

    /**
     * merge some split mini-files a large file
     *
     * @param files The mini file array. <Strong>The suffix-number of {@code files} must be ordered by asc in the array</Strong>
     * @param path The large target file will be stored in
     * @param filename Name the large target file
     */
    public static void merge(File[] files, String path, String filename) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(new File(path + filename))) {
            for (File file : files) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    byte[] b = new byte[10 * 1024 * 1024];
                    int length;
                    while ((length = fis.read(b)) != -1) {
                        fos.write(b, 0, length);
                    }
                }
            }
        }
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
}
