package com.chh.config;

import com.chh.models.mappers.CyclistMapper;
import com.chh.repository.CompetitionRepository;
import com.chh.repository.TeamRepository;
import com.chh.services.implementation.CompetitionService;
import com.chh.services.interfaces.ICompetitionService;
import com.chh.services.interfaces.ICyclistService;
import jakarta.persistence.EntityManagerFactory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.chh")
@EnableJpaRepositories(basePackages = "com.chh.repository")
public class AppConfig implements WebMvcConfigurer {

    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cch");
        dataSource.setUsername("postgres");
        dataSource.setPassword("0000");
        return dataSource;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.chh.models");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        em.getJpaPropertyMap().put("hibernate.show_sql", "false");
        em.getJpaPropertyMap().put("hibernate.format_sql", "true");
        em.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "update");

        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public ICompetitionService competitionService(CompetitionRepository competitionRepository) {
        return new CompetitionService(competitionRepository);
    }

//    @Bean
//    public ICyclistService cyclistService(CyclistMapper cyclistMapper) {
//        return new CyclistMapper(cyclistMapper);
//    }

//    @Bean
//    public InternalResourceViewResolver jspViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//    }




}
