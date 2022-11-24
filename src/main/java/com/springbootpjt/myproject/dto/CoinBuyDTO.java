package com.springbootpjt.myproject.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CoinBuyDTO {
    private Map<String, Double> amounts;
    private Map<String, Map<Double, Double>> orderBooks;
}
