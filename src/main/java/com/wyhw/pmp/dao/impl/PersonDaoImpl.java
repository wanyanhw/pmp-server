package com.wyhw.pmp.dao.impl;

import com.wyhw.pmp.entity.Person;
import com.wyhw.pmp.mapper.PersonMapper;
import com.wyhw.pmp.dao.PersonDao;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 个人信息表 服务实现类
 * </p>
 *
 * @author wanyanhw
 * @since 2022-04-26
 */
@Service
public class PersonDaoImpl extends ServiceImpl<PersonMapper, Person> implements PersonDao {

}
