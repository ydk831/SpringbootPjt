package com.springbootpjt.myproject.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootpjt.myproject.model.UpbitCoinPrice;
import com.springbootpjt.myproject.model.UpbitMarketCode;

@FeignClient(name = "upbit", url = "https://api.upbit.com/v1")
public interface UpbitFeignClient {
    @GetMapping("/ticker")
    List<UpbitCoinPrice> getCoinPrice(@RequestParam("markets") String coin);  
    
    @GetMapping("/market/all")
    List<UpbitMarketCode> getMarketCode();
}

