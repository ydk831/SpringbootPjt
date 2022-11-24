package com.springbootpjt.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springbootpjt.myproject.feign.BithumFeignClient;

@Service
//@Qualifier("bithum")
public class BithumMarketService implements MarketService {

    @Autowired
    BithumFeignClient bithumFeignClient;
    
    @Override
    public Double getCoinCurrentPrice(String coin) {
        return Double.parseDouble(bithumFeignClient.getCoinPrice(coin.toUpperCase()+"_KRW")
                .getData()
                .getClosing_price());
    }
}
