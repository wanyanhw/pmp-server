package com.wyhw.pmp.dao.impl;

import com.wyhw.pmp.dao.ServiceItemInfoDao;
import com.wyhw.pmp.entity.ServiceItemInfo;
import com.wyhw.pmp.entity.model.ServiceItemModel;
import com.wyhw.pmp.service.ServiceItemService;
import com.wyhw.pmp.service.common.IParseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wanyanhw
 * @since 2023/3/29 9:46
 */
@Service
public class ServiceItemServiceImpl implements ServiceItemService, IParseService<ServiceItemModel, ServiceItemInfo> {

    @Resource
    private ServiceItemInfoDao serviceItemInfoDao;

    @Override
    public List<ServiceItemModel> list() {
        return serviceItemInfoDao.list().stream().map(this::parse2Model).collect(Collectors.toList());
    }

    @Override
    public ServiceItemModel parse2Model(ServiceItemInfo entity) {
        ServiceItemModel model = new ServiceItemModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setRemark(entity.getRemark());
        return model;
    }

    @Override
    public ServiceItemInfo parse2Entity(ServiceItemModel model) {
        return null;
    }
}
