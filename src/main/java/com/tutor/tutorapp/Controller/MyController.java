package com.tutor.tutorapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutor.tutorapp.Service.MyService;
import com.tutor.tutorapp.Userinfo;






@RestController
public class MyController {
    @Autowired
    MyService myservice;

    public MyController() {
    }

@GetMapping("/hello")
public String hello() {
    return "Hello";
}


 @CrossOrigin(origins = "http://localhost:3000")
@PostMapping("/signup")
public String adduser(@RequestBody Userinfo userinfo) {
    myservice.adduser(userinfo);
    return "success";
}
}