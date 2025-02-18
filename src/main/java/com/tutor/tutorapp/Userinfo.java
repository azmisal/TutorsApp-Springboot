package com.tutor.tutorapp;

import java.util.ArrayList;
import java.util.List;

import  jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

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
@Transient
public String confirmPassword;
public String role;
public enum Role {
    admin,
    teacher,
    student
}
@Transient
public List<Long> bidid = new ArrayList<>();
 public List<Long> getBidid() {
        return bidid;
    }

    public void setBidid(List<Long> bidid) {
        this.bidid = bidid;
    }
}
