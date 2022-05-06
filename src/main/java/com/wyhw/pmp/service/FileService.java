package com.wyhw.pmp.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * 文件相关接口
 * @author wanyanhw
 * @date 2022/5/5 20:34
 */
public interface FileService {

    /**
     * 文件上传
     * @param file 文件
     * @return 文件保存路径
     * @throws IOException 异常
     */
    String upload(File file) throws IOException;

    /**
     * 文件上传
     * @param inputStream 输入流
     * @param filename 文件名称
     * @return 文件保存路径
     * @throws IOException 异常
     */
    String upload(InputStream inputStream, String filename) throws IOException;

    /**
     * 文件删除
     * @param path 文件路径
     * @return Boolean 删除结果
     */
    boolean delete(String path);
}
