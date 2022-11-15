package com.wyhw.pmp.controller;

import com.wyhw.pmp.entity.model.PersonInfoBrief;
import com.wyhw.pmp.entity.model.PersonInfoDetail;
import com.wyhw.pmp.entity.model.em.RelationshipEnum;
import com.wyhw.pmp.service.IPersonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wanyanhw
 * @date 2022/5/10 9:15
 */
@RestController
@RequestMapping("/person")
public class PersonController {
    @Resource
    private IPersonService personService;

    @GetMapping("/list")
    public List<PersonInfoBrief> listPerson(String name) {
        return personService.listByName(name);
    }

    @GetMapping("/detail/get")
    public PersonInfoDetail getPersonDetail(Integer personId) {
        return personService.getPersonDetail(personId);
    }

    @PostMapping("/save")
    public PersonInfoDetail savePerson(@RequestBody PersonInfoDetail personInfoDetail) {
        return personService.save(personInfoDetail);
    }

    @PostMapping("/relate/save/{personId}/{relationCode}")
    public String saveRelatedPerson(@PathVariable("personId") Integer personId,
                                    @PathVariable("relationCode") Integer relationCode,
                                    @RequestBody PersonInfoDetail personInfoDetail) {
        personService.addPersonRelationship(personId, relationCode, personInfoDetail);
        return "success";
    }

    @GetMapping("/tree/list")
    public List<PersonInfoBrief> listPersonTrees(Integer parentId) {
        return personService.selectPersonTrees(parentId);
    }

    @GetMapping("/relation/list")
    public List<Map<Integer, String>> listRelation() {
        // TODO: 2022/6/2 根据当前账号的性别信息获取家庭关系列表中的丈夫或妻子（二选一）
        return RelationshipEnum.getRelationShipList();
    }
}
