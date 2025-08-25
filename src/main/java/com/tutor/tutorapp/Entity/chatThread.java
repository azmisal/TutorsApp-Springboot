package com.tutor.tutorapp.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class chatThread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bidId;     // links to the bid

    @OneToMany(mappedBy = "thread", cascade = CascadeType.ALL)
    private List<chatmessage> messages;

    // getters/setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public List<chatmessage> getMessages() {
        return messages;
    }
     public void setMessages(List<chatmessage> messages) {
        this.messages=messages;
    }
}