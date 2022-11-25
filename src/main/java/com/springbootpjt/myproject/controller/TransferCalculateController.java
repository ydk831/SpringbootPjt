package com.springbootpjt.myproject.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpjt.myproject.service.TransferCalculateService;
import com.springbootpjt.myproject.view.TransferCalculateResponseView;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TransferCalculateController {

    final TransferCalculateService transfercalculateService;

    @GetMapping("/transfer-calculate")
    public TransferCalculateResponseView getPrice(
        @RequestParam String fromMarket,
        @RequestParam String toMarket,
        @RequestParam Double amount
    ) {
        
        // return TransferCalculateResponseView.of(transfercalculateService.calculate(fromMarket, toMarket, amount));        
        return new TransferCalculateResponseView("BTC", 123.456, Map.of(123D, 456D), Map.of(123D,456D));
    }
}
