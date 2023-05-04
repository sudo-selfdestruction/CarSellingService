package com.CarSellingService.controller;

import com.CarSellingService.entity.Offer;
import com.CarSellingService.service.OfferService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class MainController {
    private OfferService offerService;
    @GetMapping("/Offer")
    public Iterable<Offer> getAllOffers(Model model) {
        return offerService.getOffers();
    }

    @GetMapping("/Offer/{id}")
    public Optional<Offer> getOfferByID(@PathVariable("id") Offer offer) {
        return offerService.getOfferByID(offer);
    }

    @PostMapping("/Offer/create")
    public Offer saveOffer(@RequestBody Offer offer) {
        return offerService.saveOffer(offer);
    }

    @PostMapping("/Offer/{id}/update")
    public Offer updateOffer(@PathVariable("id") Offer offer, @RequestBody Offer offerRequest) {
        return offerService.updateOffer(offer, offerRequest);
    }

    @PostMapping("/Offer/{id}/delete")
    public void deleteOffer(@PathVariable("id") Offer offer) {
         offerService.deleteOffer(offer);
    }

}
