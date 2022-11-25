package com.springbootpjt.myproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpjt.myproject.service.CommonMarketService;
import com.springbootpjt.myproject.service.MarketService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MarketController {
    
    // @Autowired
    // private CommonMarketService marketService;
    final CommonMarketService commonMarketService;

    final Map<String, MarketService> marketServices;

    @GetMapping("/price")
    public Double getPrice(
            @RequestParam String market,
            @RequestParam String coin
    ) {
        
        return commonMarketService.getPrice(market, coin);
    }

    @GetMapping("/coins")
    public List<String> getCoins(
            @RequestParam String market
        ) {
            return CommonMarketService.getMarketService(marketServices, market).getCoins();                
    }

    @GetMapping("/common-coins")
    public List<String> getCommonCoins(
            @RequestParam String market1,
            @RequestParam String market2
        ) {
            return commonMarketService.getCommonCoins(market1, market2);
    }
}
