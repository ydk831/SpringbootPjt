package com.springbootpjt.myproject.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springbootpjt.myproject.feign.response.BithumbResponse;
import com.springbootpjt.myproject.model.BithubAssetEachStatus;
import com.springbootpjt.myproject.model.BithumbCoinPrice;


@FeignClient(name = "bithumb", url = "https://api.bithumb.com/public")
public interface BithumbFeignClient {
    @GetMapping("/ticker/{coin}")
    BithumbResponse<BithumbCoinPrice> getCoinPrice(@PathVariable("coin") String coin);  

    @GetMapping("/assetsstatus/ALL")
    BithumbResponse<Map<String, BithubAssetEachStatus>> getAssetStatus();
}