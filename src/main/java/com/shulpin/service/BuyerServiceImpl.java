package com.shulpin.service;

import com.shulpin.dao.BuyerDao;
import com.shulpin.model.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("buyerService")
@Transactional
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerDao dao;

    public void addBuyer(Buyer buyer) {
        dao.addBuyer(buyer);
    }

    public List<Buyer> findAllBuyer() {
        return dao.findAllBuyer();
    }

    public boolean deleteBuyerById(Long id) {
        if(dao.findBuyerById(id)==null) return false;
        else {
            dao.deleteBuyerById(id);
            return true;
        }
    }

    public void deleteAllBuyer() {
        dao.deleteAllBuyer();
    }

    public Buyer findBuyerById(Long id) {
        return dao.findBuyerById(id);
    }
}
