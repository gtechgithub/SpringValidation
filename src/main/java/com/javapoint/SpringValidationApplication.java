package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
//@ImportResource("classpath:springcontext.xml")
@ComponentScan(basePackages = "com.javapoint" )
public class SpringValidationApplication extends SpringBootServletInitializer {
    
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringValidationApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringValidationApplication.class, args);
    }
}