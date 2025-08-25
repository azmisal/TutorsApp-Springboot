package com.tutor.tutorapp.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity // Marks this as a database entity
public class chatmessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @ManyToOne
    @JoinColumn(name = "thread_id")
    private chatThread thread;
    
    private Long senderId;
    private String content;
    private LocalDateTime sentAt;

    public Long getSenderId() {
        return senderId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public Long getId() {
        return id;
    }

    public void setThread(chatThread thread) {
        this.thread = thread;
    }

    public chatThread getThread() {
        return thread;
    }

    public void setSenderId(Long senderId) {
        this.senderId=senderId;
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setSenderId'");
    }

    public void setContent(String content) {
      this.content=content;
        //throw new UnsupportedOperationException("Unimplemented method 'setContent'");
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt=sentAt;
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setSentAt'");
    }

 
}
