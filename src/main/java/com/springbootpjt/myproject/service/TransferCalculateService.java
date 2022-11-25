package com.springbootpjt.myproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springbootpjt.myproject.dto.CoinBuyDTO;
import com.springbootpjt.myproject.dto.CoinSellDTO;
import com.springbootpjt.myproject.dto.TransferCalculateDTO;
import com.springbootpjt.myproject.view.TransferCalculateResponseView;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransferCalculateService {

    final CommonMarketService commonMarketService;
    Map<String, MarketService> marketServices;

    public TransferCalculateDTO calculate(String fromMarket, String toMarket, Double amount) {
        // // from, to : common coin
        // List<String> commonCoins = commonMarketService.getCommonCoins(fromMarket, toMarket);
        
        // MarketService fromMarketService = commonMarketService.getCommonCoins(marketServices, fromMarket);
        // MarketService toMarketService = commonMarketService.getCommonCoins(marketServices, toMarket);

        // // from 얼마에 살 수 있는지
        // CoinBuyDTO fromMarketBuyDto = fromMarketservice.calculateBuy(commonCoins, amount);

        // // from 이체 수수료
        // Map<String, Double> fromMarketTransferFee = fromMarketService.calculateFee(commonCoins, amount);

        // // to 얼마에 팔 수 있는지
        // CoinSellDTO toMarketSellDto = toMarketService.calculateSell(commonCoins, amount);

        // // 가장 높은 값을 받을 수 있는 코인을 선택
        // String transferCoin = toMarketSellDto.getAmounts().keySet().get(0); // TODO: 가장 많은 현급을 받을 수 있는 코인 선택

        // return new TransferCalculateDTO(
        //     transferCoin,
        //     toMarketSellDto.getAmounts().get(transferCoin),
        //     fromMarketBuyDto.getOrderBooks().get(transferCoin),
        //     toMarketSellDto.getOrderBooks().get(transferCoin)
        // );

        return null;
    }

}
