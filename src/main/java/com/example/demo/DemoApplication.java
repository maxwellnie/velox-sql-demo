package com.example.demo;

import com.maxwellnie.velox.sql.spring.boot.DaoImplConf;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@DaoImplConf(value = "com.example.demo.po")
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
