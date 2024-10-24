package com.chh;

import com.chh.config.AppConfig;
import com.chh.models.embeddableId.CyclistCompetitionId;
import com.chh.models.embeddableId.StageCyclistId;
import com.chh.models.entities.*;
import com.chh.models.enums.StageType;
import com.chh.services.implementation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Configuration
@ComponentScan(basePackages = "com.chh")
public class Main {
    public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext cont = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext contexte = new AnnotationConfigApplicationContext(Main.class);

        TeamService teamService = context.getBean(TeamService.class);
        CyclistService cyclistService = contexte.getBean(CyclistService.class);
        CompetitionService competitionService = cont.getBean(CompetitionService.class);
        StageService stageService = contexte.getBean(StageService.class);
        CompetitionCyclistService competitionCyclistService = contexte.getBean(CompetitionCyclistService.class);
        StageCyclistService stageCyclistService = contexte.getBean(StageCyclistService.class);

//        Team newTeam = new Team();
//        newTeam.setName("SpringBoot");
//        teamService.createTeam(newTeam);
//        teamService.getAllTeam().forEach(status -> System.out.println(status.getId()));
        cyclistService.getAllCyclists().forEach(status -> System.out.println(status.getId()));
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
//        Competition competition = new Competition();
//        competition.setName("Course France");
//        competition.setYear(2023);
//        competition.setStartDate(LocalDate.of(2023, 10, 10));
//        competition.setEndDate(LocalDate.of(2023, 11, 10));
//        competitionService.createCompetition(competition);
//      competitionService.getAllCompetitionByStartDate(LocalDate.of(2023, 10, 10)).forEach(System.out::println);
//        Competition comp = competitionService.getCompetitionById(1L);
//        Stage stage = new Stage();
//        stage.setCompetition(comp);
//        stage.setStartLocation("safi");
//        stage.setEndLocation("marrakech");
//        stage.setType(StageType.FLAT);
//        stage.setDate(LocalDate.now());
//        stage.setStartTime(LocalTime.of(12,45));
//        stage.setNumber(1);
//        comp.getStages().add(stage);
//        stageService.createStage(stage);
//        System.out.println("creer succes");
//        stageService.getAllStages().forEach(System.out::println);
//        System.out.println("-----------");
//        comp.getStages().forEach(System.out::println);
//      Competition comp = competitionService.getCompetitionById(1L);
//      Cyclist cyclist = cyclistService.getCyclistById(9L);
//      Stage st = new Stage();
//      st.setCompetition(comp);
//              st.setStartLocation("oujda");
//        st.setEndLocation("casa");
//        st.setType(StageType.FLAT);
//        st.setDate(LocalDate.now());
//        st.setStartTime(LocalTime.of(5,45));
//        st.setNumber(2);
//        comp.getStages().add(st);
//        stageService.createStage(st);

      Stage stage = stageService.getStageById(5L);
//      CyclistCompetitionId cyclistCompetitionId = new CyclistCompetitionId(comp.getId(), cyclist.getId());
//      CompetitionCyclist competitionCyclist = new CompetitionCyclist();
//      competitionCyclist.setId(cyclistCompetitionId);
//      competitionCyclist.setCompetition(comp);
//      competitionCyclist.setCyclist(cyclist);
//      competitionCyclistService.createCompetitionCyclist(competitionCyclist);
//      comp.getCyclists().add(competitionCyclist);
//      cyclist.getCompetitions().add(competitionCyclist);
//      System.out.println("yes");
//      comp.getCyclists().forEach(System.out::println);
//      System.out.println("yes");
//      cyclist.getCompetitions().forEach(System.out::println);
//      System.out.println("yes");
//      competitionCyclistService.getAllCompetitionCyclists().forEach(System.out::println);
//      System.out.println("yes");
//      competitionCyclistService.findByCompetition(comp).forEach(System.out::println);
//      System.out.println("yes");
//      competitionCyclistService.findByCyclist(cyclist).forEach(System.out::println);
//
//      StageCyclistId stageCyclistId = new StageCyclistId(cyclist.getId(), stage.getId());
//      StageCyclist stageCyclist = new StageCyclist();
//      stageCyclist.setId(stageCyclistId);
//      stageCyclist.setStage(stage);
//      stageCyclist.setCyclist(cyclist);
//      stageCyclist.setTime(Duration.ofHours(10).plusMinutes(4).plusSeconds(46));
//      stageCyclistService.createStageCyclist(stageCyclist);
//      stage.getCyclists().add(stageCyclist);
//      cyclist.getStages().add(stageCyclist);
      System.out.println("succes");


    }
}