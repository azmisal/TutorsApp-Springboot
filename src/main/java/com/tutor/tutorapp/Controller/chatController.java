package com.tutor.tutorapp.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.tutor.tutorapp.Dao.chatMessageRepo;
import com.tutor.tutorapp.chatmessage;

@Controller
public class chatController {
    
   @Autowired
   chatMessageRepo repository;

    public void chatController(chatMessageRepo repository) {
        this.repository = repository;
    }

    @MessageMapping("/send") // Matches /app/send
    @SendTo("/queue/messages") // Sends messages to specific users
    public chatmessage sendMessage(chatmessage message) {
        message.setTimestamp(LocalDateTime.now().toString());
        repository.save(message); // Save the message to the database
        return message;
    }
}

