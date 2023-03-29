package com.wyhw.pmp.service;

import com.wyhw.pmp.entity.model.PackageInfoModel;

import java.util.List;

/**
 * @author wanyanhw
 * @since 2023/3/29 9:08
 */
public interface PackageService {
    /**
     * 遍历所有套餐
     * @return 套餐列表
     */
    List<PackageInfoModel> list();
}
