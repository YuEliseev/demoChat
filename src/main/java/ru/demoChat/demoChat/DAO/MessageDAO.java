package ru.demoChat.demoChat.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.demoChat.demoChat.Model.Message;

import java.util.List;

@Component
public class MessageDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private List<Message> showAllUsersMessages (int id){
        return jdbcTemplate.query("select * from message where sender = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Message.class));
    }

    private void save (Message message){
        jdbcTemplate.update("insert into message (sendingtime, sender, receiver, text) values (?, ?, ?, ?)",
                message.getSendingTime(), message.getSender(), message.getReceiver(), message.getText());
    }
}
