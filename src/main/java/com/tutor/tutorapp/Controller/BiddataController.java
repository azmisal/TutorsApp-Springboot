package com.tutor.tutorapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutor.tutorapp.Service.MyService;
import com.tutor.tutorapp.biddata;
@RestController
public class BiddataController {
    @Autowired
    MyService myservice;
@PostMapping("/add")
public String addbid(@RequestBody biddata biddata) {
    myservice.addbid(biddata);
    return "success";
}
    @GetMapping("/biddata")
public List<biddata> getbiddata() {
    return myservice.getbiddata();
}
}
