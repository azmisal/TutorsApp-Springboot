package com.tutor.tutorapp.Controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor.tutorapp.Entity.Userinfo;
import com.tutor.tutorapp.Middleware.JwtUtil;
import com.tutor.tutorapp.Service.MyService;


@RestController
@RequestMapping("/api/auth")
public class MyController {
    @Autowired
    MyService myservice;

      @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private PasswordEncoder passwordEncoder; 

    public MyController() {
    }

// @GetMapping("/home")
// public String hello() {
//     return "home";
// }
 @CrossOrigin(origins = "http://localhost:3000")
  @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");
    Map<String, Object> response = new HashMap<>();

        try {
            // Authenticate user with Spring Security
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
            );
        Userinfo user = myservice.findByEmail(email);
        String token = jwtUtil.generateToken(email);

            response.put("success", true);
            response.put("userId", user.getId());
            response.put("username", user.getUsername());
            response.put("email", user.getEmail());
            response.put("role", user.getRole());
            response.put("token", token);
        }   catch (AuthenticationException e) {
            response.put("success", false);
            response.put("message", "Invalid credentials");
        }
        return response;
    }
 @CrossOrigin(origins = "http://localhost:3000")
@PostMapping("/signup")
public String adduser(@RequestBody Userinfo userinfo) {
    userinfo.setPassword(passwordEncoder.encode(userinfo.getPassword()));
    myservice.adduser(userinfo);
    return "success";
}


}