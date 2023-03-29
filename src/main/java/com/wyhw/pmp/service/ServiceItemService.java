package com.wyhw.pmp.service;

import com.wyhw.pmp.entity.model.ServiceItemModel;

import java.util.List;

/**
 * @author wanyanhw
 * @since 2023/3/29 9:44
 */
public interface ServiceItemService {

    /**
     * 遍历所有服务项内容
     * @return 服务项列表
     */
    List<ServiceItemModel> list();
}
