package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.entity.GenealogyEntity;
import com.wyhw.pmp.service.GenealogyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GenealogyServiceImpl implements GenealogyService {

    private Person forefather;

    private class Person {
        int userId;
        int generation;
        int sex;
        String birthday;
        String address;
        Person father;
        Person mother;
        Person mate;
        Person[] children;

        Person(int userId, int generation, int sex, String birthday, String address, Person father, Person mother, Person mate, Person[] children) {
            this.userId = userId;
            this.generation = generation;
            this.sex = sex;
            this.birthday = birthday;
            this.address = address;
            this.father = father;
            this.mother = mother;
            this.mate = mate;
            this.children = children;
        }
    }

    public void init() {
        initRoot();
        generate(listAllPeople());
    }

    private void generate(List<GenealogyEntity> genealogyList) {
        Map<Integer, GenealogyEntity> genealogyMap = genealogyList.stream().collect(Collectors.toMap(GenealogyEntity::getUserId, item -> item, (v1, v2) -> v1));
    }

    private Person transfer(GenealogyEntity entity) {
        return null;
    }

    @Override
    public List<GenealogyEntity> listAllPeople() {
        // TODO: 2020/12/21 获取整个族谱列表
        return null;
    }

    private void initRoot() {
        // TODO: 2020/12/21 获取老祖宗信息
    }

}
