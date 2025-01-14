package com.tutor.tutorapp.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor.tutorapp.Userinfo;

@Repository
public interface  MyDao extends JpaRepository<Userinfo, Long>{
Optional<Userinfo> findByusername(String username);

void save(long id);
}
