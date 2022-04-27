package com.wyhw.pmp.person;

import com.wyhw.pmp.BaseTest;
import com.wyhw.pmp.entity.model.PersonInfoDetail;
import com.wyhw.pmp.service.IPersonService;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author wanyanhw
 * @date 2022/4/26 19:13
 */
public class PersonServiceTest extends BaseTest {

    @Resource
    private IPersonService iPersonService;

    @Test
    public void saveTest() {
        PersonInfoDetail infoDetail = new PersonInfoDetail();
        infoDetail.setId(1);
        infoDetail.setAccount("wanyanhongwei");
        infoDetail.setName("完颜宏伟");
        infoDetail.setSex(1);
        infoDetail.setAge(27);
        infoDetail.setBirthday("1995-08-22");
        infoDetail.setPhoneNum("15039492708");
        infoDetail.setPhoto("usr/local/photo/head.jpg");
        PersonInfoDetail save = iPersonService.save(infoDetail);
        System.out.println(save);
    }

    @Test
    public void getPersonByIdTest() {
        PersonInfoDetail personDetail = iPersonService.getPersonDetail(1);
        System.out.println(personDetail);
    }
}
