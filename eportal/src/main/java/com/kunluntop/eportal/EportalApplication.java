package com.kunluntop.eportal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication(scanBasePackages = "com.kunluntop")
@MapperScan("com.kunluntop.mapper")
@EnableRedisHttpSession
public class EportalApplication {
    public static void main(String[] args) {
        SpringApplication.run(EportalApplication.class, args);
    }
}
