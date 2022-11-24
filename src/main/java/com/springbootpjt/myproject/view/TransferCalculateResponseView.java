package com.springbootpjt.myproject.view;

import java.util.Map;

import com.springbootpjt.myproject.dto.TransferCalculateDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TransferCalculateResponseView {
    private String coin;
    private Double amount;
    private Map<Double, Double> buyOrderbook;
    private Map<Double, Double> sellOrderbook;

    //DTO -> View
    public static TransferCalculateResponseView of(TransferCalculateDTO dto) {
        return new TransferCalculateResponseView(
            dto.getCoin(),
            dto.getAmount(),
            dto.getBuyOrderBook(),
            dto.getSellOrderBook()
        );
    }    
}
