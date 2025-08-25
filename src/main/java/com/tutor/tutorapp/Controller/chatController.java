package com.tutor.tutorapp.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tutor.tutorapp.DTO.ChatMessageDTO;
import com.tutor.tutorapp.Service.ChatMessageService;

@Controller // Marks this class as a controller for handling WebSocket messages
public class ChatController {

   
  
    

 private final ChatMessageService chatMessageService;

    public ChatController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @GetMapping("/threads/{threadId}/messages")
    public List<ChatMessageDTO> getMessages(@PathVariable Long threadId) {
        return chatMessageService.getMessages(threadId)
                .stream()
                .map(ChatMessageDTO::fromEntity)
                .toList();
    }
}