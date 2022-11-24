package com.springbootpjt.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springbootpjt.myproject.feign.UpbitFeignClient;

@Service
//@Qualifier("upbit")
public class UpbitMarketservice implements MarketService{
    @Autowired
    UpbitFeignClient upbitFeginClient;
    
    @Override
    public Double getCoinCurrentPrice(String coin) {
        return upbitFeginClient.getCoinPrice("KRW-" + coin.toUpperCase())
                .get(0)
                .getTrade_price();
    }
    
}
