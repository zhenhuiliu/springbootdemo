package com.liuzhenhui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.liuzhenhui")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringbootdemoApplication extends SpringBootServletInitializer{

	@Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(SpringbootdemoApplication.class);  
    }  
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
	
	
}
