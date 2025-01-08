package com.tutor.tutorapp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.tutorapp.Dao.MyDao;
import com.tutor.tutorapp.Userinfo;



@Service
public class MyService {
    @Autowired
    MyDao mydao;


public Userinfo adduser(Userinfo userinfo) {
 return mydao.save(userinfo);
}

}