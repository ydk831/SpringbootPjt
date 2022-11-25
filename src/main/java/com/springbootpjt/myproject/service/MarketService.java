package com.springbootpjt.myproject.service;

import java.util.List;

public interface MarketService {
    public Double getCoinCurrentPrice(String coin);
    List<String> getCoins();
}
