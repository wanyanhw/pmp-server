package com.wyhw.pmp.file;

import com.wyhw.pmp.BaseTest;
import com.wyhw.pmp.service.FileService;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author wanyanhw
 * @date 2022/5/6 9:12
 */
public class FileServiceTest extends BaseTest {
    @Resource
    private FileService fileService;
    @Test
    public void uploadTest() throws IOException {
        String filePath = "C:\\Users\\wanyanhw\\Pictures\\ship.mp4";
        String uploadPath = fileService.upload(new File(filePath));
        System.out.println(uploadPath);
    }

    @Test
    public void deleteFile() {
        boolean delete = fileService.delete("D:/file/ship.mp4");
        System.out.println(delete);
    }
}
