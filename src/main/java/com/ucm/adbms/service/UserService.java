package com.ucm.adbms.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {


    public String identifyUser(String username){

        // Call DB and check
        switch (username) {
            case "ADMIN" -> {
                return "admin";
            }
            case "CUSTOMER" -> {
                return "customer";
            }
            case "VENDOR" -> {
                return "vendor";
            }
        }
        return "Not Found" ;
    }


}
