package com.springbootpjt.myproject.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransferCalculateDTO {
    private String coin;
    private Double amount;
    private Map<Double, Double> buyOrderBook;
    private Map<Double, Double> sellOrderBook;
}
