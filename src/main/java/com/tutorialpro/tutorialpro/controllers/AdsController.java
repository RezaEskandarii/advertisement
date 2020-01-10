package com.tutorialpro.tutorialpro.controllers;

import com.tutorialpro.tutorialpro.entities.HouseAd;
import com.tutorialpro.tutorialpro.entities.User;
import com.tutorialpro.tutorialpro.repository.HouseAdRepository;
import com.tutorialpro.tutorialpro.repository.UserRepository;
import com.tutorialpro.tutorialpro.services.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
@RequestMapping(value = "/profile/ads/**")
public class AdsController {

    @Autowired
    HouseAdRepository houseAdRepository;

    @Autowired
    UploadService uploadService;

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/create")
    public String getAdsPage(Model model) {
        model.addAttribute("ad", new HouseAd());
        return "profile/ad";
    }


    @PostMapping(value = "/create")
    public String createNewAd(
            @ModelAttribute HouseAd ad,
            @RequestParam("image") MultipartFile multipartFile,
            Principal principal
    ) {

        if (!multipartFile.isEmpty()) {
            String path = System.getProperty("user.dir") + "\\uploads\\" + multipartFile.getOriginalFilename();
            uploadService.upload(multipartFile, path);
            ad.setImagePath(multipartFile.getOriginalFilename());
        }
        User user = userRepository.findUserByUsername(principal.getName());
        ad.setUser(user);
        houseAdRepository.save(ad);
        System.out.println(ad.getDescription());
        return "redirect:/profile/ads/create";
    }
}
