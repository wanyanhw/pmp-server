package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.dao.IPersonInfoDao;
import com.wyhw.pmp.entity.PersonInfoEntity;
import com.wyhw.pmp.entity.model.GenealogyModel;
import com.wyhw.pmp.entity.model.em.SexEnum;
import com.wyhw.pmp.service.GenealogyService;
import com.wyhw.pmp.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GenealogyServiceImpl implements GenealogyService {

    private  IPersonInfoDao personInfoDao;

    @Autowired
    public GenealogyServiceImpl(IPersonInfoDao personInfoDao) {
        this.personInfoDao = personInfoDao;
    }

    @Override
    public List<GenealogyModel> listAllPeople() {
        List<GenealogyModel> genealogyModels = extractList(personInfoDao.listAllPeople());

        return genealogyModels;
    }

    private List<GenealogyModel> extractList(List<PersonInfoEntity> listAllPeople) {
        return listAllPeople.stream().map(this::extract).collect(Collectors.toList());
    }

    private GenealogyModel extract(PersonInfoEntity entity) {
        GenealogyModel model = new GenealogyModel();
        model.setNo("G_" + entity.getId());
        model.setName(entity.getName());
        model.setAddress(entity.getAddress());
        model.setBirthday(entity.getBirthday().format(DateUtil.STANDARD_DATE));
        model.setSex(SexEnum.getByCode(entity.getSex()).getDesc());
        return model;
    }
}
