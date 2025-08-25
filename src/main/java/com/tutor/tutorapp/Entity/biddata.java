package com.tutor.tutorapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class biddata {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long id;
    public String username;
    public String language;
    public String subject;
    public double cost;
    public String syllabus;
    public String remarks;
    public String standard;
}
