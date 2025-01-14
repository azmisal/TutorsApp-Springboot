package com.tutor.tutorapp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutor.tutorapp.biddata;

@Repository
public interface  DaoBid extends JpaRepository<biddata,Long>{
    List<biddata> findByusername(String username);
}
