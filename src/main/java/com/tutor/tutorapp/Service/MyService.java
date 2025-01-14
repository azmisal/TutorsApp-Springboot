package com.tutor.tutorapp.Service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.tutorapp.Dao.DaoBid;
import com.tutor.tutorapp.Dao.MyDao;
import com.tutor.tutorapp.Userinfo;
import com.tutor.tutorapp.biddata;

@Service
public class MyService {
    @Autowired
    MyDao mydao;
    @Autowired
    DaoBid daobid;

    public Userinfo adduser(Userinfo userinfo) {
        return mydao.save(userinfo);
    }

    public biddata addbid(biddata biddata) {
        // Save the biddata to the database and get the saved object
        biddata savedBid = daobid.save(biddata);

        // Retrieve the username from biddata
        String username = savedBid.username; // Assuming biddata has a username field

        // Fetch the corresponding Userinfo object by username
        Userinfo userinfo = mydao.findByusername(username).orElseThrow(() -> 
            new RuntimeException("User not found for username: " + username));

        // Retrieve the bidid list and ensure it's initialized
        List<Long> bidIds = userinfo.getBidid(); // Assuming bidid is stored as List<Long>
        
        if (bidIds == null) {
            bidIds = new ArrayList<>(); // Initialize if it's null
        }

        // Add the new bid ID to the list
        bidIds.add(savedBid.id); // Add the generated bid ID

        // Update the bidid field in the userinfo object
        userinfo.setBidid(bidIds); // Update the userinfo object with the modified list

        // Save the updated userinfo back to the database
        mydao.save(userinfo);

        // Return the saved biddata object
        return savedBid;
    }

    public List<biddata> getbiddata() {
        return daobid.findAll();
    }
}
