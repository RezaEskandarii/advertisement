package com.tutorialpro.tutorialpro.controllers;

import com.tutorialpro.tutorialpro.entities.HouseAd;
import com.tutorialpro.tutorialpro.repository.HouseAdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class FrontController {

    @Autowired
    HouseAdRepository adRepository;

    @GetMapping(value = "/")
    public String homePage(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size
                , Sort.by("id").descending()
        );
        Page<HouseAd> ads = adRepository.findAll(pageable);
        model.addAttribute("ads", ads.getContent());
        int[] pages = new int[ads.getTotalPages()];
        model.addAttribute("pages", pages);
        return "index";
    }

}
