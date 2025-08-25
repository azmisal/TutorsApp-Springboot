package com.tutor.tutorapp.Controller;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.tutor.tutorapp.DTO.ChatMessageDTO;
import com.tutor.tutorapp.Entity.chatmessage;
import com.tutor.tutorapp.Service.ChatMessageService;

@Controller
public class ChatWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;

    public ChatWebSocketController(SimpMessagingTemplate template, ChatMessageService service) {
        this.messagingTemplate = template;
        this.chatMessageService = service;
    }

    @MessageMapping("/chat/{threadId}")
    public void sendMessage(@DestinationVariable Long threadId, ChatMessageDTO dto) {
        chatmessage saved = chatMessageService.saveMessage(threadId, dto.getSenderId(), dto.getContent());
        ChatMessageDTO response = ChatMessageDTO.fromEntity(saved);

        messagingTemplate.convertAndSend("/topic/thread." + threadId, response);
    }
}