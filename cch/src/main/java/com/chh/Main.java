package com.chh;

import com.chh.config.AppConfig;
import com.chh.models.entities.Cyclist;
import com.chh.models.entities.Team;
import com.chh.services.implementation.CyclistService;
import com.chh.services.implementation.TeamService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.chh")
public class Main {
    public static void main(String[] args) {
//      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext cont = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext contexte = new AnnotationConfigApplicationContext(Main.class);

        TeamService teamService = contexte.getBean(TeamService.class);
//        CyclistService cyclistService = contexte.getBean(CyclistService.class);

//        Team newTeam = new Team();
//        newTeam.setName("SpringBoot");
//        teamService.createTeam(newTeam);
        teamService.getAllTeam().forEach(status -> System.out.println(status.getId()));
//        Team team= teamService.getTeamById(1L);
//        Team team =new Team();
//        team.setId(11L);
//        team.setName("Ayoub");
//        teamService.updateTeam(team);
//        teamService.deleteTeamById(11L);
//        Cyclist cyclist = new Cyclist();
//        cyclist.setTeam(team);
//        cyclist.setAge(42);
//        cyclist.setFirstname("Kamal");
//        cyclist.setLastname("Snini");
//        cyclist.setNationality("Uae");
//        cyclistService.createCyclist(cyclist);
//        team.getCyclists().add(cyclist);
//        System.out.println("suuces");
//        List<Cyclist> cyclists = team.getCyclists();
//        cyclists.forEach(System.out::println);
//        System.out.println("-----------------------------");
//
//        cyclistService.getAllCyclists().forEach(Cyclist -> System.out.print(Cyclist.getTeam().getName()));
//        cyclistService.getAllCyclists().forEach(Cyclist -> System.out.println(Cyclist.getAge()));
//        System.out.println("tri par nom");
//          cyclistService.getAllCyclistTriByName().forEach(System.out::println);
//          System.out.println("tri par national");
//        cyclistService.getAllCyclistTriByNationality().forEach(System.out::println);
//        System.out.println("all");
//        cyclistService.getAllCyclists().forEach(System.out::println);
//        System.out.println("tri par team");
//        cyclistService.getAllCyclistTriByTeam().forEach(System.out::println);
//        cyclistService.deleteCyclistById(1L);
//        System.out.println("suprimmé");
//        Cyclist cyclist = new Cyclist();
//        cyclist.setId(10L);
//        cyclist.setAge(65);
//        cyclistService.updateCyclist(cyclist);
//        System.out.println("update avec succes");

    }
}