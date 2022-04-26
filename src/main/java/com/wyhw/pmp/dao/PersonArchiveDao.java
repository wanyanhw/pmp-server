package com.wyhw.pmp.dao;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wyhw.pmp.entity.PersonArchive;

/**
 * <p>
 * 个人档案表 服务类
 * </p>
 *
 * @author wanyanhw
 * @since 2022-04-26
 */
public interface PersonArchiveDao extends IService<PersonArchive> {

    /**
     * 根据人员ID获取个人档案信息
     * @param personId 个人ID
     * @return 档案信息
     */
    PersonArchive getByPersonId(Integer personId);
}
