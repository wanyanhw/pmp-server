package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.dao.GenealogyDao;
import com.wyhw.pmp.entity.GenealogyEntity;
import com.wyhw.pmp.service.GenealogyService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GenealogyServiceImpl implements GenealogyService {

    private GenealogyDao genealogyDao;

    @Autowired
    public GenealogyServiceImpl(GenealogyDao genealogyDao) {
        this.genealogyDao = genealogyDao;
    }

    public void init() {
        initRoot();
        generate(listAllPeople());
    }

    private void generate(List<GenealogyEntity> genealogyList) {
        Map<Integer, GenealogyEntity> genealogyMap = genealogyList.stream().collect(Collectors.toMap(GenealogyEntity::getUserId, item -> item, (v1, v2) -> v1));
    }

    @Override
    public List<GenealogyEntity> listAllPeople() {
        return genealogyDao.list();
    }

    private void initRoot() {

    }

}
