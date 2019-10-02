package com.tutorialpro.tutorialpro.controllers;

import com.tutorialpro.tutorialpro.entities.User;

import com.tutorialpro.tutorialpro.repository.UserRepository;


import com.tutorialpro.tutorialpro.services.EmailService;
import com.tutorialpro.tutorialpro.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class AuthController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/signup")
    public String signUpPage(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @Autowired
    EmailService emailService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String postSignUpPage(@Valid @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            attributes.addFlashAttribute("users_exists_message", "email already exists !");
            attributes.addFlashAttribute("warning_class", "alert alert-warning");
            return "redirect:/signup";
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        user.setUsername(user.getEmail());
        String token = String.format("%s%s",
                bCryptPasswordEncoder.encode(user.getEmail()),
                TokenUtil.generateRandomToken()
        );
        token = token.replace("/", "");
        user.setToken(token);
        userRepository.save(user);
        attributes.addFlashAttribute("success_message", "user created successfully !");
        attributes.addFlashAttribute("success_class", "alert alert-success");

        String activationLink = String.format(
                "<a href='http://127.0.0.1:8080/activation/%s'> active your account </a>", user.getToken()
        );
        emailService.send(
                user.getEmail(), "activation link", activationLink
        );
        return "redirect:/signup";

    }


    @GetMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
