package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.entity.GenealogyEntity;
import com.wyhw.pmp.entity.em.SexEnum;
import com.wyhw.pmp.service.GenealogyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GenealogyServiceImpl implements GenealogyService {

    private Genealogy root;

    private class Genealogy {
        int userId;
        SexEnum sexEnum;
        String birthday;
        String address;
        Genealogy father;
        Genealogy mother;
        Genealogy spouse;
        int generation;
        Genealogy[] children;

        Genealogy(int userId, int sex, String birthday, String address, Genealogy father, Genealogy mother, Genealogy spouse, int generation, Genealogy[] children) {
            this.userId = userId;
            this.sexEnum = SexEnum.getByCode(sex);
            this.birthday = birthday;
            this.address = address;
            this.father = father;
            this.mother = mother;
            this.spouse = spouse;
            this.generation = generation;
            this.children = children;
        }
    }

    public void init() {
        initRoot();
        generate(listGenealogy());
    }

    private void generate(List<GenealogyEntity> genealogyList) {
        Map<Integer, GenealogyEntity> genealogyMap = genealogyList.stream().collect(Collectors.toMap(GenealogyEntity::getUserId, item -> item, (v1, v2) -> v1));
    }

    private Genealogy transfer(GenealogyEntity entity) {
        return null;
    }

    private List<GenealogyEntity> listGenealogy() {
        // TODO: 2020/12/21 获取整个族谱列表
        return null;
    }

    private void initRoot() {
        // TODO: 2020/12/21 获取老祖宗信息
    }

}
