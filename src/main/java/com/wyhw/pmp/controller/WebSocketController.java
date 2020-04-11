package com.wyhw.pmp.controller;

import com.wyhw.pmp.websocket.WebSocketServer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ws")
public class WebSocketController {

    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView modelAndView = new ModelAndView("/socket");
        modelAndView.addObject("cid", cid);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public String pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message, cid);
            return message;
        } catch (Exception e) {
            e.printStackTrace();
            return "发送失败";
        }
    }

}
