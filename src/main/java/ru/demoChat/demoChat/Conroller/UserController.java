package ru.demoChat.demoChat.Conroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public static String showAllUsers(){

        return "allUsers";
    }

    @GetMapping
    public static String newUser(){

        return "newUser";
    }

    @PostMapping
    public static String saveUser(){
        return "redirect:users/allUsers";
    }
}
