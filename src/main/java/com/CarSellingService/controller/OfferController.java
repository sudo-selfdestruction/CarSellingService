package com.CarSellingService.controller;

import com.CarSellingService.entity.Offer;
import com.CarSellingService.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class OfferController {

    @Autowired
    private OfferRepository offerRepository;
    @GetMapping("/offers.html")
    public String offers(Model model) {
        Iterable<Offer> offers = offerRepository.findAll();
        model.addAttribute("title", "Offers");
        model.addAttribute("offers", offers);
        return "offers";
    }
}
