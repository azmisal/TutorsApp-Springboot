package com.tutor.tutorapp.Controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.tutor.tutorapp.Dao.chatMessageRepo;
import com.tutor.tutorapp.chatmessage;

@Controller // Marks this class as a controller for handling WebSocket messages
public class ChatController {

    @Autowired
    private chatMessageRepo repository;

    // Constructor (explained below)
    public ChatController(chatMessageRepo repository) {
        this.repository = repository;
    }

    @MessageMapping("/send") // Maps frontend messages sent to "/app/send"
    @SendTo("/queue/messages") // Broadcasts the message to "/queue/messages"
    public chatmessage sendMessage(chatmessage message) {
        message.setTimestamp(LocalDateTime.now().toString());
        repository.save(message); // Saves message to the database
        return message; // Returns the message to be sent back to clients
    }
}
