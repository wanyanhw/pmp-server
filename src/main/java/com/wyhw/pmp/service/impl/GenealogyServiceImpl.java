package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.dao.IPersonInfoDao;
import com.wyhw.pmp.entity.PersonInfoEntity;
import com.wyhw.pmp.service.GenealogyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GenealogyServiceImpl implements GenealogyService {

    private IPersonInfoDao personInfoDao;

    @Autowired
    public GenealogyServiceImpl(IPersonInfoDao personInfoDao) {
        this.personInfoDao = personInfoDao;
        this.init();
    }

    private void init() {
        generate(listAllPeople());
    }

    private void generate(List<PersonInfoEntity> personInfoEntities) {
        Map<Integer, PersonInfoEntity> personMap = personInfoEntities.stream().collect(Collectors.toMap(PersonInfoEntity::getId, item -> item, (v1, v2) -> v1));

    }

    @Override
    public List<PersonInfoEntity> listAllPeople() {
        return personInfoDao.list();
    }

}
