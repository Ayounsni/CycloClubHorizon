package com.chh;

import com.chh.models.entities.Team;
import com.chh.services.implementation.TeamService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TeamService teamService = (TeamService) context.getBean("teamService");

        Team newTeam = new Team();
        newTeam.setName("Wora");
        teamService.createTeam(newTeam);

        teamService.getAllTeam().forEach(status -> System.out.println(status.getName()));
    }
}