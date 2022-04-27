package com.wyhw.pmp.service.impl;

import com.wyhw.pmp.dao.PersonArchiveDao;
import com.wyhw.pmp.dao.PersonDao;
import com.wyhw.pmp.dao.PersonRelationshipDao;
import com.wyhw.pmp.entity.Person;
import com.wyhw.pmp.entity.PersonArchive;
import com.wyhw.pmp.entity.PersonRelationship;
import com.wyhw.pmp.entity.model.AccountStatusEnum;
import com.wyhw.pmp.entity.model.PersonInfoBrief;
import com.wyhw.pmp.entity.model.PersonInfoDetail;
import com.wyhw.pmp.service.IPersonService;
import com.wyhw.pmp.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wanyanhw
 * @date 2022/4/26 19:17
 */
@Service
public class PersonServiceImpl implements IPersonService {

    @Resource
    private PersonDao personDao;
    @Resource
    private PersonArchiveDao personArchiveDao;
    @Resource
    private PersonRelationshipDao personRelationshipDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PersonInfoDetail save(PersonInfoDetail personInfoDetail) {
        // 1、创建账号信息
        Person person = new Person();
        person.setId(personInfoDetail.getId());
        person.setAccount(personInfoDetail.getAccount());
        person.setPassword("123456");
        person.setName(personInfoDetail.getName());
        person.setStatus(AccountStatusEnum.FREE.getCode());
        personDao.saveOrUpdate(person);

        // 2、创建档案信息
        PersonArchive personArchive = personArchiveDao.getByPersonId(person.getId());
        if (personArchive == null) {
            personArchive = new PersonArchive();
            personArchive.setPersonId(person.getId());
        }
        String birthday = personInfoDetail.getBirthday();
        String deathDay = personInfoDetail.getDeathDay();
        personArchive.setBirthday(birthday == null ? null : LocalDateTime.of(LocalDate.parse(birthday, DateUtil.STANDARD_DATE), LocalTime.now()));
        personArchive.setDeathDay(deathDay == null ? null : LocalDateTime.of(LocalDate.parse(deathDay, DateUtil.STANDARD_DATE), LocalTime.now()));
        personArchive.setAddress(personInfoDetail.getAddress());
        personArchive.setMobilePhone(personInfoDetail.getPhoneNum());
        personArchive.setSex(personInfoDetail.getSex());
        personArchive.setAge(personInfoDetail.getAge());
        personArchive.setPhoto(personInfoDetail.getPhoto());
        personArchiveDao.saveOrUpdate(personArchive);

        personInfoDetail.setId(person.getId());
        personInfoDetail.setSex(personArchive.getSex());
        personInfoDetail.setAge(personArchive.getAge());
        return personInfoDetail;
    }

    @Override
    public void removePerson(Integer personId) {

    }

    @Override
    public List<PersonInfoBrief> listByName(String name) {
        return null;
    }

    @Override
    public PersonInfoDetail getPersonDetail(Integer personId) {
        Person person = personDao.getById(personId);
        PersonArchive personArchive = personArchiveDao.getByPersonId(personId);
        if (personArchive == null) {
            personArchive = new PersonArchive();
        }
        List<PersonRelationship> personRelations = personRelationshipDao.listByPersonId(personId);

        int relatesPersonSize = personRelations.size();
        final Map<Integer, List<Person>> relatedPersonListMap = new HashMap<>(relatesPersonSize);
        if (relatesPersonSize > 0) {
            Set<Integer> relatedPersonIds = personRelations.stream().map(PersonRelationship::getPersonId).collect(Collectors.toSet());
            relatedPersonListMap.putAll(personDao.listByIds(relatedPersonIds).stream().collect(Collectors.groupingBy(Person::getId)));
        }

        PersonInfoDetail personInfoDetail = new PersonInfoDetail();
        personInfoDetail.setId(personId);
        personInfoDetail.setAccount(person.getAccount());
        personInfoDetail.setName(person.getName());
        personInfoDetail.setPhoto(personArchive.getPhoto());
        personInfoDetail.setPhoneNum(personArchive.getMobilePhone());
        LocalDateTime birthday = personArchive.getBirthday();
        LocalDateTime deathDay = personArchive.getDeathDay();
        personInfoDetail.setBirthday(birthday == null ? null : birthday.format(DateUtil.STANDARD_DATE));
        personInfoDetail.setDeathDay(deathDay == null ? null : deathDay.format(DateUtil.STANDARD_DATE));
        personInfoDetail.setSex(personArchive.getSex());
        personInfoDetail.setAge(personArchive.getAge());
        personInfoDetail.setAddress(personArchive.getAddress());
        personInfoDetail.setAlive(deathDay == null);

        List<PersonInfoBrief> personRelationBriefList = personRelations.stream().map(personRelationship -> {
            Integer personRelationshipId = personRelationship.getId();
            List<Person> relatedPersonList = relatedPersonListMap.get(personRelationshipId);
            Person relatedPerson;
            if (relatedPersonList == null || relatedPersonList.isEmpty()) {
                relatedPerson = new Person();
            } else {
                relatedPerson = relatedPersonList.get(0);
            }

            PersonInfoBrief personInfoBrief = new PersonInfoBrief();
            personInfoBrief.setId(personRelationshipId);
            personInfoBrief.setAccount(relatedPerson.getAccount());
            personInfoBrief.setName(relatedPerson.getName());
            return personInfoBrief;
        }).collect(Collectors.toList());

        personInfoDetail.setFamilyMembers(personRelationBriefList);
        return personInfoDetail;
    }

    @Override
    public void addPersonRelationship(Integer personId, PersonInfoDetail relatePersonInfoDetail) {

    }

    @Override
    public void delPersonRelationship(Integer personId, Integer relatePersonId) {

    }

    @Override
    public List<PersonInfoBrief> getPersonRelationships(Integer personId) {
        return null;
    }
}
