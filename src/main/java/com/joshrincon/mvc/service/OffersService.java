package com.joshrincon.mvc.service;

import com.joshrincon.mvc.dao.Offer;
import com.joshrincon.mvc.dao.OffersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("offersService")
public class OffersService {

    private OffersDAO offersDAO;

    @Autowired
    public void setOffersDAO(OffersDAO offersDAO) {
        this.offersDAO = offersDAO;
    }

    public List<Offer> getCurrent() {
        return offersDAO.getOffers();
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public void create(Offer offer) {
        offersDAO.create(offer);
    }

    public void throwTestException() {
        offersDAO.getOffer(999999);
    }
}
