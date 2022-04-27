package com.wyhw.pmp.dao.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyhw.pmp.dao.PersonRelationshipDao;
import com.wyhw.pmp.entity.PersonRelationship;
import com.wyhw.pmp.mapper.PersonRelationshipMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人关系表 服务实现类
 * </p>
 *
 * @author wanyanhw
 * @since 2022-04-26
 */
@Service
public class PersonRelationshipDaoImpl extends ServiceImpl<PersonRelationshipMapper, PersonRelationship> implements PersonRelationshipDao {

    @Override
    public List<PersonRelationship> listByPersonId(Integer personId) {
        return lambdaQuery().eq(PersonRelationship::getPersonId, personId).list();
    }
}
