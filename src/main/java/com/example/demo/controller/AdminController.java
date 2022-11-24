package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {
    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin_page")
    public ResponseEntity<List<User>> userList() {
        final List<User> users = userService.findAllUsers();
        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(users, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/admin_page/new")
    public List<User> addUser(@RequestBody User user) {
        userService.saveUser(user);
        return userService.findAllUsers();
    }

    @PutMapping("/admin_page/edit")
    public ResponseEntity<?> update(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/admin_page/{id}")
    public ResponseEntity<Void> removeUser(@PathVariable Long id) {
        userService.deleteUser(userService.findUserById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}