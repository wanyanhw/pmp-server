package com.wyhw.pmp.service;

/**
 * 文件类接口
 */
public interface FileService {

    String CHUNK_SEPARATOR = "&&";

    /**
     * 保存文件到指定位置
     * @param target 保存目标位置
     * @param fileName 文件名称
     * @param chunkIndex 文件分片序号
     * @param bytes 文件字节
     * @return true-保存成功 false-保存失败
     */
    boolean saveFile2Path(String target, String fileName, int chunkIndex, byte[] bytes);

    /**
     * 合并分片文件，合并时注意分片序号，从低到高合并
     * @param path 文件位置
     * @param fileName 文件名
     * @param chunkTotal 总分片数
     * @return true-合并成功 false-合并失败
     */
    boolean mergeSliceFile(String path, String fileName, int chunkTotal);

    /**
     * 播放媒体文件
     * @param path 文件路径
     */
    void play(String path);
}
