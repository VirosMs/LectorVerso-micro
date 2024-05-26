package org.virosms.lectorversomicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.virosms.lectorversomicro.controller.UserController;

@SpringBootApplication
@Import({UserController.class})
public class LectorversoMicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(LectorversoMicroApplication.class, args);
    }

}
