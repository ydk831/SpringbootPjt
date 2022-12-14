package com.springbootpjt.myproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springbootpjt.myproject.feign.UpbitFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//@Qualifier("upbit")
public class UpbitMarketservice implements MarketService{
    // @Autowired
    // UpbitFeignClient upbitFeginClient;
    final UpbitFeignClient upbitFeginClient;
    
    @Override
    public Double getCoinCurrentPrice(String coin) {
        return upbitFeginClient.getCoinPrice("KRW-" + coin.toUpperCase())
                .get(0)
                .getTrade_price();
    }

    @Override
    public List<String> getCoins() {
        List<String> result = new ArrayList<>();
        upbitFeginClient.getMarketCode().forEach(k -> {
            if(k.getMarket().startsWith("KRW"))  {
                result.add(k.getMarket().substring(4).toUpperCase());                
            }
        });

        return result;
    }
    
}
