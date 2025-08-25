package com.tutor.tutorapp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutor.tutorapp.Entity.chatmessage;

public interface chatMessageRepo extends JpaRepository<chatmessage, Long> {
    //List<chatmessage> findBySenderOrReceiver(String sender, String receiver);
     List<chatmessage> findByThreadIdOrderBySentAtAsc(Long threadId);
}
