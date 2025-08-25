package com.tutor.tutorapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication; // ✅ Add this import


import com.tutor.tutorapp.Entity.biddata;
import com.tutor.tutorapp.Service.MyService;

import jakarta.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/api/bids")
@CrossOrigin(origins = "http://localhost:3000") // applies to all methods
public class BidController {

    @Autowired
    private MyService myservice;

    @PostMapping("/addbid")
    public String addbid(@RequestBody biddata biddata, 
                         HttpServletRequest request, 
                         Authentication authentication) {
        
        // Debug information
        System.out.println("=== DEBUG INFO ===");
        System.out.println("Authorization header: " + request.getHeader("Authorization"));
        System.out.println("Authentication object: " + authentication);
        System.out.println("Is authenticated: " + (authentication != null && authentication.isAuthenticated()));
        
        if (authentication != null) {
            System.out.println("User: " + authentication.getName());
            System.out.println("Authorities: " + authentication.getAuthorities());
        }
        
        System.out.println("Received bid data: " + biddata.toString());
        System.out.println("==================");
        
        myservice.addbid(biddata);
        return "success";
    }

    @GetMapping("/getbid")
    public List<biddata> getbiddata() {
        return myservice.getbiddata();
    }
}