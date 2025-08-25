package com.tutor.tutorapp.Entity;

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

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}
public String firstName;
public String lastName;
public String username;
public String email;
public long mobile;
public String password;

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getUsername() {
    return username;
}

public void setUsername(String username) {
    this.username = username;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public long getMobile() {
    return mobile;
}

public void setMobile(long mobile) {
    this.mobile = mobile;
}

public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}
@Transient
public String confirmPassword;
public String role;

public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
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
