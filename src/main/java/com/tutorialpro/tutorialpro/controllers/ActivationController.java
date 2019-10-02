package com.tutorialpro.tutorialpro.controllers;

import com.tutorialpro.tutorialpro.entities.User;
import com.tutorialpro.tutorialpro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class ActivationController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/activation/{token}")
    public String activeUserByToken(
            @PathVariable("token") String token
    ) {
        User user = userRepository.findByToken(token);
        if (user != null) {
            userRepository.activeUserByTokenAndId(token, user.getId());
        }
        return "redirect:/login";
    }

}
