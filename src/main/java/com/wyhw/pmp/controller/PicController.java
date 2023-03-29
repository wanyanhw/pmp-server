package com.wyhw.pmp.controller;

import com.wyhw.pmp.entity.model.PicModel;
import com.wyhw.pmp.service.PictureService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wanyanhw
 * @since 2023/3/27 9:14
 */
@RestController
@RequestMapping("/pic")
public class PicController {

    @Resource
    private PictureService pictureService;

    @GetMapping("/list")
    public List<PicModel> listPic() {
        return pictureService.list();
    }

    @PostMapping("/save")
    public String save(MultipartFile file) {
        pictureService.save(file);
        return "success";
    }

    @ApiOperation("获取优选图集")
    @GetMapping("/getTopList")
    public List<PicModel> getTopList() {
        return pictureService.listTop();
    }
}
