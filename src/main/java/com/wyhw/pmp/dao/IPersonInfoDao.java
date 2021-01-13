package com.wyhw.pmp.dao;

import com.wyhw.pmp.entity.PersonInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wanyanhw
 * @since 2021-01-13
 */
public interface IPersonInfoDao extends IService<PersonInfoEntity> {

    List<PersonInfoEntity> listAllPeople();
}
