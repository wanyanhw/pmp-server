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

    public static void main(String[] args) {
        String fileName = "abc.JPG";
        String[] strings = fileName.split("\\.");
        System.out.println(strings.length);
    }
}
