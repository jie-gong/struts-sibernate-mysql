package com.gong.strutssibernatemysql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@MapperScan("com.gong.strutssibernatemysql.mapper")

@SpringBootApplication
public class StrutsSibernateMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrutsSibernateMysqlApplication.class, args);
    }

}
