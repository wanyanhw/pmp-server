package com.wyhw.pmp.controller;

import com.alibaba.fastjson.JSONObject;
import com.wyhw.pmp.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@Slf4j
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @ResponseBody
    @PostMapping("/sliceUpload")
    public String sliceUpload(@RequestParam("fileName") String fileName,
                              @RequestParam("chunkIndex") int chunkIndex,
                              @RequestParam("fileData") MultipartFile fileData) {
        JSONObject result = new JSONObject();
        try {
            byte[] bytes = fileData.getBytes();
            String path = "E:\\pic";
            boolean successed = fileService.saveFile2Path(path, fileName, chunkIndex, bytes);
            if (successed) {
                result.put("status", 200);
                result.put("msg", "成功");
                return result.toJSONString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.put("status", 500);
        result.put("msg", "失败");
        return result.toJSONString();
    }

    @ResponseBody
    @PostMapping("/mergeUpload")
    public String mergeUpload(@RequestParam("fileName") String fileName,
                              @RequestParam("chunkTotal") int chunkTotal) {
        JSONObject result = new JSONObject();
        String path = "E:\\pic";
        boolean successed = fileService.mergeSliceFile(path, fileName, chunkTotal);
        if (successed) {
            result.put("status", 200);
            result.put("msg", "成功");
            return result.toJSONString();
        }
        result.put("status", 500);
        result.put("msg", "失败");
        return result.toJSONString();
    }
}
