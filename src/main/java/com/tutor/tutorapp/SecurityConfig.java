package com.tutor.tutorapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.tutor.tutorapp.Service.MyUserDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    MyUserDetails mydetails;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors(cors -> cors.disable()).csrf(csrf -> csrf.disable()); // Enable CORS and disable CSRF for testing
        return http.authorizeHttpRequests(Registry->{Registry.requestMatchers("/home").permitAll();
    Registry.anyRequest().authenticated();})   
         .build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
       return mydetails;
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(mydetails);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
     @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use BCrypt for password encoding
        return NoOpPasswordEncoder.getInstance();
    }
}

