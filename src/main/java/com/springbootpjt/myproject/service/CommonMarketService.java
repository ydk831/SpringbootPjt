package com.springbootpjt.myproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonMarketService {
    //@Autowired
    //@Qualifier("bitsum")
    //MarketService bitsumMarketService;
    
    // @Autowired
    // @Qualifier("upbit")
    // MarketService  upbitMarketService;   
    

    // @Autowired
    //List<MarketService> marketSerivces;
    final Map<String, MarketService> marketServices;
    
    public Double getPrice(String market, String coin) {
        
        //MarketService marketService = null;        
        //for(String key : marketServices.keySet()) {
        //
        //    //System.out.println(key);
        //    if(key.substring(0,market.length()).equals(market.toLowerCase())) {
        //        marketService = marketServices.get(key);
        //    }            
        //}
        MarketService marketService = getMarketService(marketServices, market);
        return marketService.getCoinCurrentPrice(coin);
    }

    public static MarketService getMarketService(Map<String, MarketService> marketServices, String market) {
        for(String key : marketServices.keySet()) {
            if(key.substring(0,market.length()).equals(market.toLowerCase())) {
                return marketServices.get(key);
            }
        }
        return null;
    }

    public List<String> getCommonCoins(String fromMarket, String toMarket) {
        // 마켓 서비스 가져와
        MarketService fromMarketService = getMarketService(marketServices, fromMarket);
        MarketService toMarketService = getMarketService(marketServices, toMarket);
        
        // 각 마켓의 거래가능 코인 불러오기
        List<String> fromMarketCoins = fromMarketService.getCoins();
        List<String> toMarketCoins = toMarketService.getCoins();

        // 공통의것 찾기
        List<String> result = new ArrayList<>();
        for (String eachCoin :  fromMarketCoins) {
            if (toMarketCoins.contains(eachCoin)) {
                result.add(eachCoin);
            }
        }
        
        return result;
    }
    
}
