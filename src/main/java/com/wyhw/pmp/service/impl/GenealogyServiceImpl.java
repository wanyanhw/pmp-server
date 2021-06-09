package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.dao.IPersonInfoDao;
import com.wyhw.pmp.dao.IPersonRelationDao;
import com.wyhw.pmp.entity.PersonInfoEntity;
import com.wyhw.pmp.entity.PersonRelationEntity;
import com.wyhw.pmp.entity.model.GenealogyModel;
import com.wyhw.pmp.entity.model.em.SexEnum;
import com.wyhw.pmp.service.GenealogyService;
import com.wyhw.pmp.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GenealogyServiceImpl implements GenealogyService {

    private IPersonInfoDao personInfoDao;
    private IPersonRelationDao personRelationDao;

    @Autowired
    public GenealogyServiceImpl(IPersonInfoDao personInfoDao, IPersonRelationDao personRelationDao) {
        this.personInfoDao = personInfoDao;
        this.personRelationDao = personRelationDao;
        initInfo();
    }

    private static Map<String, GenealogyModel> PERSON_INFO_MAP = null;

    private static List<PersonRelationEntity> PERSON_RELATION = null;

    private void initInfo() {
        PERSON_INFO_MAP = extractList(personInfoDao.list()).stream().collect(Collectors.toMap(GenealogyModel::getNo, p -> p, (v1, v2) -> v2));
        PERSON_RELATION = personRelationDao.list();
    }

    @Override
    public List<GenealogyModel> listAllPeople() {
        add();
        return null;
    }

    private void add() {
        if (root == null) {
            List<PersonRelationEntity> roots = PERSON_RELATION.stream().filter(p -> StringUtils.isEmpty(p.getFatherId())).collect(Collectors.toList());
            if (roots.isEmpty()) {
                log.info("没有祖先信息");
                return;
            }
            if (roots.size() > 1) {
                log.info("祖先信息错误");
                return;
            }
            PersonRelationEntity rootPerson = roots.get(0);
            Integer id = rootPerson.getId();
            root = new Node(id, null, 1, PERSON_INFO_MAP.get(id.toString()).getName(), childrenNodes(id));
        }
        Node t = root;
        fill(t);

    }

    private void fill(Node t) {
        for (Node child : t.children) {
            while (child.children != null) {
                // TODO: 2021/1/13 递归添加孩子信息
                fill(child);
            }
        }
    }

    private Node[] childrenNodes(Integer personId) {
        // TODO: 2021/1/13 返回所有孩子
        return null;
    }

    private List<GenealogyModel> extractList(List<PersonInfoEntity> listAllPeople) {
        return listAllPeople.stream().map(this::extract).collect(Collectors.toList());
    }

    private GenealogyModel extract(PersonInfoEntity entity) {
        GenealogyModel model = new GenealogyModel();
        model.setNo(String.valueOf(entity.getId()));
        model.setName(entity.getName());
        model.setAddress(entity.getAddress());
        model.setBirthday(entity.getBirthday() == null ? "" : entity.getBirthday().format(DateUtil.STANDARD_DATE));
        model.setSex(SexEnum.getByCode(entity.getSex()).getDesc());
        return model;
    }

    private Node root;

    @Data
    @AllArgsConstructor
    private class Node {
        private int id;
        private Node father;
        private int generation;
        private String name;
        private Node[] children;
    }

}
