package com.springbootpjt.myproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springbootpjt.myproject.feign.BithumbFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
//@Qualifier("bithum")
public class BithumbMarketService implements MarketService {

    // @Autowired
    // BithumFeignClient bithumFeignClient;
    final BithumbFeignClient bithumbFeignClient;
    
    @Override
    public Double getCoinCurrentPrice(String coin) {
        return Double.parseDouble(bithumbFeignClient.getCoinPrice(coin.toUpperCase()+"_KRW")
                .getData()
                .getClosing_price());
    }

    @Override
    public List<String> getCoins() {
        List<String> result = new ArrayList<>();
        bithumbFeignClient.getAssetStatus().getData().forEach((k,v) -> {
            if(v.getDeposit_status() == 1 && v.getWithdrawal_status() == 1) {
                result.add(k.toUpperCase());
            }
        });
        return result;
    }
}
