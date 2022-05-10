package com.wyhw.pmp.service;

import com.wyhw.pmp.entity.model.PersonInfoBrief;
import com.wyhw.pmp.entity.model.PersonInfoDetail;
import com.wyhw.pmp.entity.model.PersonInfoRelation;

import java.util.List;

/**
 * @author wanyanhw
 * @date 2022/4/26 15:12
 */
public interface IPersonService {

    /**
     * 保存个人信息详情并返回
     * @param personInfoDetail 个人信息详情
     * @return 保存后的个人信息详情
     */
    PersonInfoDetail save(PersonInfoDetail personInfoDetail);

    /**
     * 根据{@code personId}删除人员信息
     * @param personId 人员ID
     */
    void removePerson(Integer personId);

    /**
     * 根据姓名获取人员信息列表
     * @param name 姓名
     * @return 人员信息列表
     */
    List<PersonInfoBrief> listByName(String name);

    /**
     * 根据{@code personId}获取人员信息详情
     * @param personId 人员ID
     * @return 人员信息
     */
    PersonInfoDetail getPersonDetail(Integer personId);

    /**
     * 添加个人关系并创建关系账号
     * @param personId 人员ID
     * @param relationship 关系类型 {@link com.wyhw.pmp.entity.model.em.RelationshipEnum}
     * @param relatePersonInfoDetail 关系成员信息详情
     */
    void addPersonRelationship(Integer personId, Integer relationship, PersonInfoDetail relatePersonInfoDetail);

    /**
     * 删除指定关系人
     * @param personId 人员ID
     * @param relatePersonId 关系人员ID
     */
    void delPersonRelationship(Integer personId, Integer relatePersonId);

    /**
     * 根据{@code personId}获取人员关系信息列表
     * @param personId 人员ID
     * @return 关系列表
     */
    List<PersonInfoRelation> getPersonRelationships(Integer personId);
}
