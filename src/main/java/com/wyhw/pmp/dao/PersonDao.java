package com.wyhw.pmp.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyhw.pmp.entity.Person;
import com.wyhw.pmp.entity.model.PersonInfoBrief;

import java.util.List;

/**
 * <p>
 * 个人信息表 服务类
 * </p>
 *
 * @author wanyanhw
 * @since 2022-04-26
 */
public interface PersonDao extends IService<Person> {

    /**
     * 根据人员ID删除个人信息
     * @param personId 个人ID
     * @return Boolean
     */
    boolean deletePerson(Integer personId);

    /**
     * 根据姓名查询个人信息
     * @param name 姓名
     * @return List
     */
    List<Person> listByName(String name);

    /**
     * 根据人员ID获取人员信息
     * @param personId 人员ID
     * @return 人员信息
     */
    Person getPersonById(Integer personId);

    /**
     * 获取人物关系图谱
     * @param parentId 父ID
     * @return List
     */
    List<PersonInfoBrief> selectPersonTrees(Integer parentId);

    /**
     * 添加父ID
     * @param personId 个人ID
     * @param parentId 父ID
     * @return boolean
     */
    boolean addParent(Integer personId, Integer parentId);
}
