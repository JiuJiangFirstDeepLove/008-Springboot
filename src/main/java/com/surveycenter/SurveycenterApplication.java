package com.surveycenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.surveycenter.mapper")
public class SurveycenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveycenterApplication.class, args);
    }
}

