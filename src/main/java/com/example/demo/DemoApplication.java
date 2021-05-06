package com.example.demo;

import com.example.demo.domain.Post;
import com.example.demo.service.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication  {   // implements CommandLineRunner

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private ApplicationContext appContext;

//    @Override
//    public void run(String... args) throws Exception {
//
//
//
//        String[] beans = appContext.getBeanDefinitionNames();
//
//        Arrays.stream(beans)
//                .sorted()
//                .forEach(System.out::println);
//
//    }

}
