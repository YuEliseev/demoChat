package ru.demoChat.demoChat.Config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@NoArgsConstructor
@ConfigurationProperties(prefix = "postgres-param")
public class DBConfig {
    private String url;
    private String user;
    private String password;
    private String driver;
}


//    create table users(
//        id serial primary key,
//        name varchar not null,
//        age int,
//        status varchar,
//        about varchar
//        )
//
//    create table messages(
//        id serial primary key,
//        sendingTime date,
//        sender int not null,
//        receiver int not null ,
//        text text,
//        constraint fk_sender foreign key(sender) references users(id),
//        constraint fk_receiver foreign key(receiver) references users(id)
//        )