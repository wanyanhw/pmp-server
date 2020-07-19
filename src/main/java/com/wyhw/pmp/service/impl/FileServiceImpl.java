package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.service.FileService;
import com.wyhw.pmp.util.MultipartFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private MultipartFileUtils fileUtils;

    @Override
    public boolean saveFile2Path(String target, String fileName, int chunkIndex, byte[] bytes) {
        fileName = fileName.replace(".", CHUNK_SEPARATOR + chunkIndex + ".");
        return fileUtils.saveFile(target, fileName, bytes);
    }

    @Override
    public boolean mergeSliceFile(String path, String fileName, int chunkTotal) {
        return fileUtils.mergeFile(path, fileName, CHUNK_SEPARATOR, chunkTotal);
    }
}
