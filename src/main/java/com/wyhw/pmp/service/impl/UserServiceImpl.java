package com.wyhw.pmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wyhw.pmp.dao.UserDao;
import com.wyhw.pmp.entity.UserEntity;
import com.wyhw.pmp.service.UserService;
import com.wyhw.pmp.threadLocal.UserSession;
import com.wyhw.pmp.util.ExcelUtils;
import org.apache.commons.collections4.map.LinkedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity getUserInfo(String ... args) {
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<>();
        if (args[0] != null) {
            queryWrapper.eq("id", args[0]);
        } else {
            queryWrapper.eq("username", args[1]);
            queryWrapper.eq("password", args[2]);
        }
        return userDao.getOne(queryWrapper);
    }

    @Override
    public Collection<UserEntity> getAllUserInfo() {
        return userDao.list();
    }

    @Override
    public void export(HttpServletResponse response, String fileName, String[] titles,
        Collection<UserEntity> allUserInfoList) {
        List<LinkedMap> dataMapList = new ArrayList<>();
        allUserInfoList.forEach(item -> {
            LinkedMap dataMap = new LinkedMap();
            dataMap.put(0, item.getId());
            dataMap.put(1, item.getUsername());
            dataMap.put(2, item.getPassword());
            dataMap.put(3, item.getClass());
            dataMapList.add(dataMap);
        });

        new ExcelUtils().exportExcel(response, fileName, titles, dataMapList);
    }

}
