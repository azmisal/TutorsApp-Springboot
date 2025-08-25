package com.tutor.tutorapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutor.tutorapp.Entity.chatThread;

public interface ChatthreadRepository extends JpaRepository<chatThread, Long> {

}