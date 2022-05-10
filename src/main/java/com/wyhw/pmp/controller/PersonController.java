package com.wyhw.pmp.controller;

import com.wyhw.pmp.entity.model.PersonInfoBrief;
import com.wyhw.pmp.service.IPersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
}
