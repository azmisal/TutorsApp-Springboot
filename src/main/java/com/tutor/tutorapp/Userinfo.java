package com.tutor.tutorapp;

import  jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Userinfo {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public long id;
public String firstName;
public String lastName;
public String username;
public String email;
public long  mobile;
public String password;
public String confirmPassword;
}
