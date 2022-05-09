package com.wyhw.pmp.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyhw.pmp.dao.PersonDao;
import com.wyhw.pmp.entity.Person;
import com.wyhw.pmp.mapper.PersonMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

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

    @Override
    public boolean deletePerson(Integer personId) {
        return lambdaUpdate()
                .eq(Person::getId, personId)
                .set(Person::getDeleted, true)
                .update();
    }

    @Override
    public List<Person> listByName(String name) {
        return lambdaQuery()
                .like(!StringUtils.isEmpty(name), Person::getName, name)
                .eq(Person::getDeleted, false)
                .list();

    }

    @Override
    public Person getPersonById(Integer personId) {
        return getOne(new LambdaQueryWrapper<Person>()
                .eq(Person::getId, personId)
                .eq(Person::getDeleted, false));
    }
}
