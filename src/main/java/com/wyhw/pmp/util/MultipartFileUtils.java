package com.wyhw.pmp.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * 文件工具类
 */
@Slf4j
@Component
public class MultipartFileUtils {


    /**
     * 保存文件到指定路径
     * @param path 文件路径
     * @param fileName 文件名
     * @param bytes 文件字节
     * @return true-成功 false-失败
     */
    public boolean saveFile(String path, String fileName, byte[] bytes) {
        BufferedOutputStream os = null;
        File dir = new File(path);
        if (!dir.isDirectory()) {
            // 目标不存在则新建目录
            dir.mkdirs();
        }
        try {
            File file = new File(path + File.separator + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            os = new BufferedOutputStream(fos);
            os.write(bytes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 合并文件
     * 注意：合并文件时需按分片顺序从小到大合并
     * @param path 文件位置
     * @param fileName 文件名称
     * @param separator 分片文件分隔符号，符号前为文件名称（无类型），符号后为分片序号
     * @param chunkTotal 总分片数
     * @return true-合并成功 false-合并失败
     */
    public boolean mergeFile(String path, String fileName, String separator, int chunkTotal) {
        File dir = new File(path);
        boolean isDirectory = dir.isDirectory();
        if (!isDirectory) {
            log.info("目标文件夹不存在");
            return false;
        }
        String[] fileArguments = fileName.split("\\.");
        if (fileArguments.length != 2) {
            if (fileArguments.length == 1) {
                log.info("未指定文件类型");
            } else {
                log.info("文件格式不正确");
            }
            return false;
        }
        String targetName = fileArguments[0];
        String targetType = fileArguments[1];

        File[] files = dir.listFiles();
        if (files == null) {
            log.info("目标文件分片不存在");
            return false;
        }

        BufferedOutputStream os = null;
        FileOutputStream fos = null;
        try {
            File targetFile = new File(path + File.separator + fileName);
            fos = new FileOutputStream(targetFile);
            os = new BufferedOutputStream(fos);
            byte[] bytes = new byte[1024 * 1024 * 2];
            int chunkIndex = 1;
            while (chunkIndex <= chunkTotal) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        continue;
                    }
                    String tempFileName = file.getName();
                    String[] tempFileArguments = tempFileName.split("\\.");
                    String[] tempName = tempFileArguments[0].split(separator);
                    if (tempName.length != 2) {
                        log.info("当前文件不符合格式：{}", tempFileName);
                        continue;
                    }
                    String type = tempFileArguments[1];
                    String name = tempName[0];
                    int index = Integer.parseInt(tempName[1]);
                    if (targetName.equals(name) && targetType.equals(type) && index == chunkIndex) {
                        chunkIndex ++;
                        FileInputStream fis = new FileInputStream(file);
                        int count = -1;
                        while ((count = fis.read(bytes)) != -1) {
                            os.write(bytes, 0, count);
                        }
                        fis.close();
                        file.delete();
                        break;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
    public File[] splitByQuantity(File file, int total, String filename, String basePath) throws IOException{
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
    private File[] splitBySize(File file, int size, String filename, String basePath) throws IOException {
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
    public void merge(File[] files, String path, String filename) throws IOException {
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

    public static void main(String[] args) {
        String fileName = "abc.JPG";
        String[] strings = fileName.split("\\.");
        System.out.println(strings.length);
    }
}
