package com.CarSellingService.service;

import com.CarSellingService.entity.Offer;
import com.CarSellingService.entity.User;
import com.CarSellingService.repository.OfferRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;
    @Autowired
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

    public Offer updateOffer(Offer offer, Offer offerRequest) {
        User user = userService.getUserByLogin();
        if (user.getId().equals(offer.getUserId())) {
            offerRequest.setId(offer.getId());
            offerRequest.setUserId(offer.getUserId());
            return offerRepository.save(offerRequest);
        }
        return null;
    }

    public void deleteOffer(Offer offer) {
        User user = userService.getUserByLogin();
        if(user.getId().equals(offer.getUserId())) {
            offerRepository.delete(offer);
        }
    }
}
