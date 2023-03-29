package com.wyhw.pmp.controller;

import com.wyhw.pmp.entity.model.ServiceItemModel;
import com.wyhw.pmp.service.ServiceItemService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wanyanhw
 * @since 2023/3/29 9:17
 */
@RestController
@RequestMapping("/service")
@Api(tags = "服务项接口")
public class ServiceItemController {

    @Resource
    private ServiceItemService itemService;

    public List<ServiceItemModel> list() {
        return itemService.list();
    }
}
