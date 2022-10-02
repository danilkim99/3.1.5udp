package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.ValidationException;

import static java.util.Objects.isNull;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
