package com.wyhw.pmp.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyhw.pmp.dao.ServiceItemInfoDao;
import com.wyhw.pmp.entity.ServiceItemInfo;
import com.wyhw.pmp.mapper.ServiceItemInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类型信息表 服务实现类
 * </p>
 *
 * @author wanyanhw
 * @since 2023-03-28
 */
@Service
public class ServiceItemInfoDaoImpl extends ServiceImpl<ServiceItemInfoMapper, ServiceItemInfo> implements ServiceItemInfoDao {

}
