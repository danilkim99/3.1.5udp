package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;


public interface UserService {

    User findUserById(Long id);
    List<User> findAllUsers();
    User saveUser(User user);
    void deleteUser(User user);
    User findByUsername(String username);
    List<Role> listRoles();
    void updateUser(User user);
    UserDetails loadUserByUsername(String username);
}
