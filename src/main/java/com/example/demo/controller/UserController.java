package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/user")
    public String userInfo(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        return "user-info";
    }

    @GetMapping("/admin/{id}")
    public String userById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user-info";
    }


    @GetMapping("/admin")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/admin/user-create")
    public String createUserForm(User use) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUserForm(User user, @RequestParam(value = "role") String[] roles) {
        user.setRoles(userService.getRoles(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/admin/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "/user-update";
    }

    @PostMapping("/admin/user-update")
    public String updateUser(User user, @RequestParam(value = "role") String[] roles) {
        user.setRoles(userService.getRoles(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }
}
