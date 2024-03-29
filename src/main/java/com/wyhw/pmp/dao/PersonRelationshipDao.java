package com.wyhw.pmp.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyhw.pmp.entity.PersonRelationship;

import java.util.List;

/**
 * <p>
 * 个人关系表 服务类
 * </p>
 *
 * @author wanyanhw
 * @since 2022-04-26
 */
public interface PersonRelationshipDao extends IService<PersonRelationship> {

    /**
     * 根据人员ID获取个人关系列表
     * @param personId 个人ID
     * @return 关系列表
     */
    List<PersonRelationship> listByPersonId(Integer personId);

    /**
     * 根据人员ID删除个人所有关系
     * @param personId 人员ID
     * @return Boolean
     */
    boolean deletePersonRelation(Integer personId);

    /**
     * 删除人员特定亲属关系
     * @param personId 人员ID
     * @param relatePersonId 亲属ID
     * @return Boolean
     */
    boolean deletePersonRelation(Integer personId, Integer relatePersonId);
}
