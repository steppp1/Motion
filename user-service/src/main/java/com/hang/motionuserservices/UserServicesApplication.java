package com.hang.motionuserservices;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //开启注解方式的事务管理
@EnableCaching
@Slf4j
@SpringBootApplication
public class UserServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServicesApplication.class, args);
    }

}
