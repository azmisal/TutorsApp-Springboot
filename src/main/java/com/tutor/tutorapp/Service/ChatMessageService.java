package com.tutor.tutorapp.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tutor.tutorapp.Dao.ChatthreadRepository;
import com.tutor.tutorapp.Dao.chatMessageRepo;
import com.tutor.tutorapp.Entity.chatThread;
import com.tutor.tutorapp.Entity.chatmessage;
@Service
public class ChatMessageService {

    private final chatMessageRepo chatMessageRepository;
    private final ChatthreadRepository chatThreadRepository;

    public ChatMessageService(chatMessageRepo msgRepo, ChatthreadRepository threadRepo) {
        this.chatMessageRepository = msgRepo;
        this.chatThreadRepository = threadRepo;
    }

    public chatmessage saveMessage(Long threadId, Long senderId, String content) {
        chatThread thread = chatThreadRepository.findById(threadId)
                .orElseThrow(() -> new RuntimeException("Thread not found"));

        chatmessage message = new chatmessage();
        message.setThread(thread);
        message.setSenderId(senderId);
        message.setContent(content);
        message.setSentAt(LocalDateTime.now());

        return chatMessageRepository.save(message);
    }

    public List<chatmessage> getMessages(Long threadId) {
        return chatMessageRepository.findByThreadIdOrderBySentAtAsc(threadId);
    }
}