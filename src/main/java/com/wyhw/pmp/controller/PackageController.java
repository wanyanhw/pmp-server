package com.wyhw.pmp.controller;

import com.wyhw.pmp.entity.model.PackageInfoModel;
import com.wyhw.pmp.service.PackageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wanyanhw
 * @since 2023/3/28 13:39
 */
@Api("套餐接口")
@RestController
@RequestMapping("/package")
public class PackageController {

    @Resource
    private PackageService packageService;

    @ApiOperation("查询套餐")
    @GetMapping("/list")
    public List<PackageInfoModel> listPackages() {
        return packageService.list();
    }
}
