package com.wyhw.pmp.file;

import com.wyhw.pmp.BaseTest;
import com.wyhw.pmp.service.FileService;
import com.wyhw.pmp.util.FileUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * @author wanyanhw
 * @date 2022/5/6 9:12
 */
public class FileServiceTest extends BaseTest {

    @Value("${file.path}")
    private String filePath;
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

    private File[] files;

    @Test
    public void chunkUploadTest() {
        File sourceFile1 = new File("C:\\Users\\wanyanhw\\Pictures\\ship.mp4");
        File sourceFile2 = new File("E:\\素材\\视频\\video2.mp4");
        try {
            files = FileUtil.splitByQuantity(sourceFile1, 5, "ship.mp4", filePath);
            files = FileUtil.splitByQuantity(sourceFile2, 10, "video2.mp4", filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mergeTest() {
        try {
            File file = new File(filePath);
            files = file.listFiles();
            FileUtil.merge(files, filePath, "ship.mp4");
            FileUtil.merge(files, filePath, "video2.mp4");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
