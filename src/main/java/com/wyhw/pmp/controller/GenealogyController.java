package com.wyhw.pmp.controller;

import com.wyhw.pmp.service.GenealogyService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 家谱服务接口
 */
@Api(value = "家谱接口")
@RestController
@RequestMapping("/genealogy")
public class GenealogyController {
    @Autowired
    private GenealogyService genealogyService;


}
