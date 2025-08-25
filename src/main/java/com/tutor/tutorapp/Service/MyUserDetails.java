package com.tutor.tutorapp.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tutor.tutorapp.Dao.MyDao;
import com.tutor.tutorapp.Entity.Userinfo;
@Service
public class MyUserDetails implements UserDetailsService {
    @Autowired
    MyDao mydao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Optional<Userinfo> user= mydao.findByusername(username);
     if(user.isPresent()){
        var userobj=user.get();
        return User.builder()
        .username(userobj.username).password(userobj.password).build();
     }
    else{
        throw new UsernameNotFoundException(username);
    }
    }

}
