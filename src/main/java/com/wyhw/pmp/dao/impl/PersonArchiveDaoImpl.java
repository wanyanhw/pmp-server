package com.wyhw.pmp.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wyhw.pmp.dao.PersonArchiveDao;
import com.wyhw.pmp.entity.PersonArchive;
import com.wyhw.pmp.mapper.PersonArchiveMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人档案表 服务实现类
 * </p>
 *
 * @author wanyanhw
 * @since 2022-04-26
 */
@Service
public class PersonArchiveDaoImpl extends ServiceImpl<PersonArchiveMapper, PersonArchive> implements PersonArchiveDao {

    @Override
    public PersonArchive getByPersonId(Integer personId) {
        return getOne(new LambdaQueryWrapper<PersonArchive>().eq(PersonArchive::getPersonId, personId));
    }

    @Override
    public List<PersonArchive> listByPersonIds(List<Integer> personIds) {
        return lambdaQuery()
                .in(PersonArchive::getPersonId, personIds)
                .list();
    }
}
