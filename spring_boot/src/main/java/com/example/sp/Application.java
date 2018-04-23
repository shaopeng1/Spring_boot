package com.example.sp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableCaching //缓存策略
@EnableEurekaServer
@MapperScan("com.example.sp.mapper")//扫描
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
