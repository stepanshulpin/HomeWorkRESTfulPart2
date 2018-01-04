package com.shulpin.controller;


import com.shulpin.model.Buyer;
import com.shulpin.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuyerController {

    @Autowired
    BuyerService buyerService;

    @GetMapping(value = "/buyer", produces = "application/json")
    @Transactional
    public ResponseEntity<List<Buyer>> getAllBuyer(){
        return new ResponseEntity<List<Buyer>>(buyerService.findAllBuyer(), HttpStatus.OK);
    }

    @GetMapping(value = "/buyer/{id}", produces = "application/json")
    @Transactional
    public ResponseEntity getBuyer(@PathVariable("id") Long id) {

        Buyer buyer = buyerService.findBuyerById(id);
        if (buyer == null) {
            return new ResponseEntity("No Buyer found for ID " + id, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(buyer, HttpStatus.OK);
    }

    @PostMapping(value = "/buyer", consumes = "application/json")
    @Transactional
    public ResponseEntity<Buyer> addBuyer(@RequestBody Buyer buyer){
        buyerService.addBuyer(buyer);
        return new ResponseEntity<Buyer>(buyer, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/buyer")
    @Transactional
    public ResponseEntity deleteAllBuyer(){
        buyerService.deleteAllBuyer();
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/buyer/{id}")
    @Transactional
    public ResponseEntity deleteAllBuyer(@PathVariable("id") Long id){
        if(buyerService.deleteBuyerById(id))
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
