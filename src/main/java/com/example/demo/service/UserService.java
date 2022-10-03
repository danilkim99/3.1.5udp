package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Set;

public interface UserService {

    User findById(Long id);
    List<User> findAll();
    User saveUser(User user);
    void deleteById(Long id);
    User findByUsername(String username);
    Set<Role> getRoles(String[] roles);
}
