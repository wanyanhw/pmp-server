package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.dao.PackageInfoDao;
import com.wyhw.pmp.entity.PackageInfo;
import com.wyhw.pmp.entity.model.PackageInfoModel;
import com.wyhw.pmp.service.PackageService;
import com.wyhw.pmp.service.common.IParseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanyanhw
 * @since 2023/3/29 9:09
 */
@Service
public class PackageServiceImpl implements PackageService, IParseService<PackageInfoModel, PackageInfo> {

    @Resource
    private PackageInfoDao packageInfoDao;

    @Override
    public List<PackageInfoModel> list() {
        List<PackageInfo> list = packageInfoDao.list();
        return list.stream().map(this::parse2Model).collect(Collectors.toList());
    }

    @Override
    public PackageInfoModel parse2Model(PackageInfo entity) {
        PackageInfoModel model = new PackageInfoModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setPrice(entity.getPrice());
        model.setRemark(entity.getRemark());
        return model;
    }

    @Override
    public PackageInfo parse2Entity(PackageInfoModel model) {
        return null;
    }
}
