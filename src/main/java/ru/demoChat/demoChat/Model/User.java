package ru.demoChat.demoChat.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private int id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Age should not be empty")
    private int age;
    private String status;
    private String about;

}
