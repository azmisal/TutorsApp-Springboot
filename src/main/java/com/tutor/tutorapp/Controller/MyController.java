package com.tutor.tutorapp.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tutor.tutorapp.Service.MyService;
import com.tutor.tutorapp.Userinfo;


@Controller
public class MyController {
    @Autowired
    MyService myservice;

    public MyController() {
    }

@GetMapping("/home")
public String hello() {
    return "home";
}
@GetMapping("/login")
public String loginPage() {
    return "login"; // Returns login.html from templates
}
 @CrossOrigin(origins = "http://localhost:3000")
@PostMapping("/signup")
public String adduser(@RequestBody Userinfo userinfo) {
    myservice.adduser(userinfo);
    return "success";
}


}