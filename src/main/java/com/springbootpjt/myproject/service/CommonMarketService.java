package com.springbootpjt.myproject.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CommonMarketService {
    //@Autowired
    //@Qualifier("bitsum")
    //MarketService bitsumMarketService;
    
    // @Autowired
    // @Qualifier("upbit")
    // MarketService  upbitMarketService;   
    

    @Autowired
    //List<MarketService> marketSerivces;
    Map<String, MarketService> marketServices;
    
    public Double getPrice(String market, String coin) {
        
        //MarketService marketService = null;        
        //for(String key : marketServices.keySet()) {
        //
        //    //System.out.println(key);
        //    if(key.substring(0,market.length()).equals(market.toLowerCase())) {
        //        marketService = marketServices.get(key);
        //    }            
        //}
        MarketService marketService = getCommonCoins(marketServices, market);
        return marketService.getCoinCurrentPrice(coin);
        
        // if(market.equals("bitsum")) {
        // } else if (market.equals("upbit")) {
            // return upbitMarketService.getCoinCurrentPrice(coin);
        // }

        // return 0.0;
    }

    public static MarketService getCommonCoins(Map<String, MarketService> marketServices, String market) {
        for(String key : marketServices.keySet()) {
            if(key.substring(0,market.length()).equals(market.toLowerCase())) {
                return marketServices.get(key);
            }
        }
        return null;
    }
}
