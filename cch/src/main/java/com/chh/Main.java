package com.chh;

import com.chh.models.entities.Status;
import com.chh.services.StatusService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        StatusService statusService = (StatusService) context.getBean("statusService");

        // Créer un nouveau statut
        Status newStatus = new Status();
        newStatus.setNom("Active");
        statusService.createStatus(newStatus);

        // Récupérer et afficher tous les statuts
        statusService.getAllStatus().forEach(status -> System.out.println(status.getNom()));
    }
}