package com.wyhw.pmp.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyhw.pmp.dao.PackageInfoDao;
import com.wyhw.pmp.entity.PackageInfo;
import com.wyhw.pmp.mapper.PackageInfoMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 套餐信息表 服务实现类
 * </p>
 *
 * @author wanyanhw
 * @since 2023-03-28
 */
@Service
public class PackageInfoDaoImpl extends ServiceImpl<PackageInfoMapper, PackageInfo> implements PackageInfoDao {

}
