package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.service.FileService;
import com.wyhw.pmp.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wanyanhw
 * @date 2022/5/5 20:55
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${file.path}")
    private String filePath;

    @Override
    public String upload(File file) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            return upload(fileInputStream, file.getName());
        }
    }

    @Override
    public String upload(InputStream inputStream, String filename) throws IOException {
        byte[] bytes = FileUtil.toByteArray(inputStream);
        boolean success = FileUtil.saveFile(filePath, filename, bytes);
        if (success) {
            return filePath + filename;
        }
        return "";
    }

    @Override
    public boolean delete(String path) {
        File file = new File(path);
        return file.delete();
    }
}
