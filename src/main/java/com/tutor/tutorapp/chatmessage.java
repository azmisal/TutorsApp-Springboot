package com.tutor.tutorapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class chatmessage {
    @Id
    @GeneratedValue
    private Long id;
    private String sender;
    private String receiver;
    private String content;
    private String timestamp;
    public void setTimestamp(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTimestamp'");
    }

    // Getters and setters
}
