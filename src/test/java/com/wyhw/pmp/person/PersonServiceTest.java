package com.wyhw.pmp.person;

import com.wyhw.pmp.BaseTest;
import com.wyhw.pmp.entity.model.PersonInfoBrief;
import com.wyhw.pmp.entity.model.PersonInfoDetail;
import com.wyhw.pmp.entity.model.PersonInfoRelation;
import com.wyhw.pmp.entity.model.em.RelationshipEnum;
import com.wyhw.pmp.service.IPersonService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

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
        infoDetail.setAccount("ming");
        infoDetail.setName("刘小明");
        infoDetail.setSex(1);
        infoDetail.setAge(18);
        infoDetail.setBirthday("2024-01-19");
        infoDetail.setPhoneNum("16633632254");
        infoDetail.setPhoto("usr/local/photo/head.jpg");
        PersonInfoDetail save = iPersonService.save(infoDetail);
        System.out.println(save);
    }

    @Test
    public void getPersonByIdTest() {
        PersonInfoDetail personDetail = iPersonService.getPersonDetail(1);
        System.out.println(personDetail);
    }

    @Test
    public void addRelationPerson() {
        PersonInfoDetail relatedPerson = new PersonInfoDetail();
        relatedPerson.setName("刘峰");
        relatedPerson.setSex(1);
        relatedPerson.setBirthday("1973-03-26");
        relatedPerson.setAccount("liufeng");
        relatedPerson.setPhoneNum("17154663336");
        iPersonService.addPersonRelationship(1, RelationshipEnum.FATHER.getCode(), relatedPerson);
    }

    @Test
    public void showRelatedPerson() {
        List<PersonInfoRelation> personRelationships = iPersonService.getPersonRelationships(1);
        personRelationships.forEach(System.out::println);
    }

    @Test
    public void deletePerson() {
        iPersonService.removePerson(1);
    }

    @Test
    public void listByName() {
        List<PersonInfoBrief> personInfoBriefs = iPersonService.listByName("哈");
        personInfoBriefs.forEach(System.out::println);
    }

    @Test
    public void deletePersonRelationship() {
        iPersonService.delPersonRelationship(1, 4);
    }
}
