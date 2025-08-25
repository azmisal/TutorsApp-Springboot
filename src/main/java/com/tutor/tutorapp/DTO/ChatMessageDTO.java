package com.tutor.tutorapp.DTO;
import java.time.LocalDateTime;

import com.tutor.tutorapp.Entity.chatmessage;

public class ChatMessageDTO {
    private Long id;
    private Long senderId;
    private String content;
    private LocalDateTime sentAt;

    // convert Entity -> DTO
    public static ChatMessageDTO fromEntity(chatmessage msg) {
        ChatMessageDTO dto = new ChatMessageDTO();
        dto.setId(msg.getId());
        dto.setSenderId(msg.getSenderId());
        dto.setContent(msg.getContent());
        dto.setSentAt(msg.getSentAt());
        return dto;
    }

    private void setSentAt(LocalDateTime sentAt) {
        // TODO Auto-generated method stub
        this.sentAt=sentAt;
        //throw new UnsupportedOperationException("Unimplemented method 'setSentAt'");
    }

    private void setContent(String content) {
        // TODO Auto-generated method stub
        this.content=content;
        //throw new UnsupportedOperationException("Unimplemented method 'setContent'");
    }

    private void setSenderId(Long senderId) {
        // TODO Auto-generated method stub
        this.senderId=senderId;
        //throw new UnsupportedOperationException("Unimplemented method 'setSenderId'");
    }

    private void setId(Long id) {
        // TODO Auto-generated method stub
        this.id=id;
        //throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public Long getSenderId() {
        return senderId;
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getSenderId'");
    }

    public String getContent() {
        return content;
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'getContent'");
    }

    // getters/setters
}
