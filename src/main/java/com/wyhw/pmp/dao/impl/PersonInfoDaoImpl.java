package com.wyhw.pmp.dao.impl;

import com.wyhw.pmp.entity.PersonInfoEntity;
import com.wyhw.pmp.mapper.PersonInfoMapper;
import com.wyhw.pmp.dao.IPersonInfoDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wanyanhw
 * @since 2021-01-13
 */
@Service
public class PersonInfoDaoImpl extends ServiceImpl<PersonInfoMapper, PersonInfoEntity> implements IPersonInfoDao {

}
