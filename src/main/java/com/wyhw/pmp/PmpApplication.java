package com.wyhw.pmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.wyhw.pmp.mapper"})
public class PmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmpApplication.class, args);
    }

}
