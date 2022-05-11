package com.wyhw.pmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wyhw.pmp.entity.Person;
import com.wyhw.pmp.entity.model.PersonInfoBrief;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 个人信息表 Mapper 接口
 * </p>
 *
 * @author wanyanhw
 * @since 2022-04-26
 */
public interface PersonMapper extends BaseMapper<Person> {

    /**
     * 获取人物关系图谱
     * @param parentId 父ID
     * @return List
     */
    List<PersonInfoBrief> selectPersonTrees(@Param(value = "parentId") Integer parentId);
}
