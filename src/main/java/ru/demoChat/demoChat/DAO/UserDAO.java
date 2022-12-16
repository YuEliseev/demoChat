package ru.demoChat.demoChat.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.demoChat.demoChat.Model.User;

import java.util.List;

@Component
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> showAll(){
        return jdbcTemplate.query("Select * from users",
                new BeanPropertyRowMapper<>(User.class));
    }

    public User getById(int id){
        return jdbcTemplate.query("select * from users where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }

    public void save(User user){
        jdbcTemplate.update("insert into users (name, age, status, about) values (?, ?, ?, ?)",
                user.getName(), user.getAge(), user.getStatus(), user.getAbout());
    }

    public void update(User user){
        jdbcTemplate.update("update users set name = ?, age = ?, status = ?, about = ?",
                user.getName(), user.getAge(), user.getStatus(), user.getAbout());
    }

    public void delete (int id){
        jdbcTemplate.update("delete from users where id = ?", id);
    }

}
