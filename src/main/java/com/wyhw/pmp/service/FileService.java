package com.wyhw.pmp.service;

import java.io.InputStream;

/**
 * 文件相关接口
 * @author wanyanhw
 * @date 2022/5/5 20:34
 */
public interface FileService {

    /**
     * 文件上传
     * @param inputStream 输入流
     * @return 文件保存路径
     */
    String upload(InputStream inputStream);

    /**
     * 文件删除
     * @param path 文件路径
     */
    void delete(String path);
}
