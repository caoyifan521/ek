package com.qfedu.ek;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//扫描dao层
@MapperScan("com.qfedu.ek.dao")
public class EkApplication {

    public static void main(String[] args) {
        SpringApplication.run(EkApplication.class, args);
    }

}
