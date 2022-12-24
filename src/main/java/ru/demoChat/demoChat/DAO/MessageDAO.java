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

    public List<Message> getOutcome(int id){
        return jdbcTemplate.query("select * from message where sender = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Message.class));
    }

    public List<Message> getIncome(int id){
        return jdbcTemplate.query("select * from message where receiver = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Message.class));
    }

    public void save (Message message){
        jdbcTemplate.update("insert into message (sendingdatetime, sender, receiver, text) values (?, ?, ?, ?)",
                "current_timestamp", message.getSender(), message.getReceiver(), message.getText());
    }
}
