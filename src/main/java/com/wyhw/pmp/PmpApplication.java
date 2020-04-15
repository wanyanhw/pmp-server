package com.wyhw.pmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.wyhw.pmp.mapper"})
@ServletComponentScan(basePackages = {"com.wyhw.pmp.config"})
public class PmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmpApplication.class, args);
    }

}
