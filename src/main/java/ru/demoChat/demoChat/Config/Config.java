package ru.demoChat.demoChat.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ru/demoChat/demoChat")
public class Config {

    @Autowired
    DBConfig dbConfig;

    @Bean
    public DataSource dataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                dbConfig.getUrl(),
                dbConfig.getUser(),
                dbConfig.getPassword()
        );
        dataSource.setDriverClassName(dbConfig.getDriver());
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }



}
