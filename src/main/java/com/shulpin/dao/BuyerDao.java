package com.shulpin.dao;

import com.shulpin.model.Buyer;

import java.util.List;

public interface BuyerDao {

    void addBuyer(Buyer buyer);

    List<Buyer> findAllBuyer();

    void deleteBuyerById(Long id);

    void deleteAllBuyer();

    Buyer findBuyerById(Long id);

}
