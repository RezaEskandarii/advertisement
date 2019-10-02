package com.tutorialpro.tutorialpro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String getPrfoilePage(){
        return "profile/home";
    }
}
