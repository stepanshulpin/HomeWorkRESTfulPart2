package com.shulpin.service;

import com.shulpin.model.Buyer;

import java.util.List;

public interface BuyerService {

    void addBuyer(Buyer buyer);

    List<Buyer> findAllBuyer();

    boolean deleteBuyerById(Long id);

    void deleteAllBuyer();

    Buyer findBuyerById(Long id);

}
