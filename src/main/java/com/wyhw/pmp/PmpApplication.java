package com.wyhw.pmp;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@MapperScan(basePackages = {"com.wyhw.pmp.mapper"})
@ServletComponentScan(basePackages = {"com.wyhw.pmp.config"})
@EnableJms
@EnableDubbo
public class PmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmpApplication.class, args);
    }

}
