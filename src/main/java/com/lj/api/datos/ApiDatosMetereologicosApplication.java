package com.lj.api.datos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class ApiDatosMetereologicosApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiDatosMetereologicosApplication.class, args);
    }
}
