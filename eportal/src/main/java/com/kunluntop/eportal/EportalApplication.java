package com.kunluntop.eportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication(scanBasePackages = "com.kunluntop")
@MapperScan("com.kunluntop.mapper")
public class EportalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EportalApplication.class, args);
    }

}
