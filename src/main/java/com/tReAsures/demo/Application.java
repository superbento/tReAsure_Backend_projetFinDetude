package com.tReAsures.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.tReAsures.demo.dao")
@ServletComponentScan
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	//只有在构建war文件并进行部署时才需要
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//将更多源（配置类和组件）添加到此应用程序。
		return application.sources(Application.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
