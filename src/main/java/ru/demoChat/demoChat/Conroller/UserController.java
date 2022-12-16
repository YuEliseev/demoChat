package ru.demoChat.demoChat.Conroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.demoChat.demoChat.DAO.UserDAO;
import ru.demoChat.demoChat.Model.User;

@Controller
@RequestMapping("/users")
public class UserController {


    private final UserDAO userDAO;
    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public String showAllUsers(Model model){
        model.addAttribute("users", userDAO.showAll());
        return "allUsers";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable ("id") int id, Model model ){
        model.addAttribute("user", userDAO.getById(id));
        return "userPage";
    }

    @GetMapping("/newUser")
    public String newUser(Model model){
            model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("user") User user){
        userDAO.save(user);
        return "redirect:/users";
    }
}
