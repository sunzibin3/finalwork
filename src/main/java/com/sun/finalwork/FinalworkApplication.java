package com.sun.finalwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value="com.sun.finalwork.mapper")
@SpringBootApplication
public class FinalworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalworkApplication.class, args);
    }

}
