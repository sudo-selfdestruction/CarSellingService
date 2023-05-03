package com.CarSellingService.service;

import com.CarSellingService.entity.Offer;
import com.CarSellingService.entity.User;
import com.CarSellingService.repository.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OfferService {
    private OfferRepository offerRepository;
    private UserService userService;
    public Iterable<Offer> getOffers() {
        return offerRepository.findAll();
    }

    public Optional<Offer> getOfferByID(Offer offer) {
        return offerRepository.findById(offer.getId());
    }

    public Offer saveOffer(Offer offer) {
        User user = userService.getUserByLogin();
        offer.setUserId(user.getId());
        return offerRepository.save(offer);
    }
}
