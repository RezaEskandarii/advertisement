package com.tutorialpro.tutorialpro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "profile/**")
public class ProfileController {

    @GetMapping("/profile")
    public String getPrfoilePage(){
        return "profile/home";
    }

}
