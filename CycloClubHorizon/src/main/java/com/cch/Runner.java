package com.cch;

import com.cch.models.entities.Status;
import com.cch.services.implementation.StatusService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class Runner {
     public static void main(String[] args) {
//         SpringApplication.run(Runner.class, args);
         ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

         StatusService statusService = context.getBean("statusService", StatusService.class);

         Status status = new Status();
         status.setId(5L);
         status.setNom("Actif");

         statusService.addStatus(status);
    }
}
