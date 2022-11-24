package com.springbootpjt.myproject.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springbootpjt.myproject.feign.response.BithumResponse;
import com.springbootpjt.myproject.model.BithumCoinPrice;


@FeignClient(name = "bithum", url = "https://api.bithumb.com/public")
public interface BithumFeignClient {
    @GetMapping("/ticker/{coin}")
    BithumResponse<BithumCoinPrice> getCoinPrice(@PathVariable("coin") String coin);  
}