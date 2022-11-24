package com.springbootpjt.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpjt.myproject.service.CommonMarketService;

@RestController
public class MarketController {
    
    @Autowired
    private CommonMarketService marketService;

    @GetMapping("/price")
    public Double getPrice(
            @RequestParam String market,
            @RequestParam String coin
    ) {
        
        return marketService.getPrice(market, coin);
    }
}
