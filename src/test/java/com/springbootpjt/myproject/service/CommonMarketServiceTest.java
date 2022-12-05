package com.springbootpjt.myproject.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CommonMarketServiceTest {
    
    @Mock
    BithumbMarketService bithumbMarketService;
    @Mock
    UpbitMarketservice upbitMarketService;

    // CommonMarketService commonMarketService = new CommonMarketService(Map.of("bithumbMarketService",bithumbMarketService));
    CommonMarketService commonMarketService;

    @BeforeEach
    void setUp() {
        commonMarketService = new CommonMarketService(
            Map.of("bithumbMarketService",bithumbMarketService,
                    "upbitMarketService",upbitMarketService)
            );
    }

    @Test
    void getCommonCoinsTests() {

    }

    @Test
    void getMarketServiceTests() {
        // given
        Map<String, MarketService> marketServices = new HashMap<>();
        marketServices.put("bithumbMarketService", bithumbMarketService);
        marketServices.put("upbitMarketService", upbitMarketService);

        // when & then 
        // assertEquals(bithumbMarketService, CommonMarketService.getMarketService(marketServices,"bithumb"));
        // assertEquals(bithumbMarketService, CommonMarketService.getMarketService(marketServices,"Bithumb"));
        // assertEquals(bithumbMarketService, CommonMarketService.getMarketService(marketServices,"bITHUMb"));
        // assertEquals(bithumbMarketService, CommonMarketService.getMarketService(marketServices,"bithumB"));

        assertEquals(upbitMarketService, CommonMarketService.getMarketService(marketServices,"upbit"));
        assertEquals(upbitMarketService, CommonMarketService.getMarketService(marketServices,"Upbit"));
        assertEquals(upbitMarketService, CommonMarketService.getMarketService(marketServices,"upbiT"));
        assertEquals(upbitMarketService, CommonMarketService.getMarketService(marketServices,"UPBIT"));
    }

    @Test
    void getPriceTests() {
        // given : 어떤 상황이 주어질때
        Double testAmount = 123.456;
        String testCoin = "testCoin";
        when(bithumbMarketService.getCoinCurrentPrice(testCoin)).thenReturn(testAmount);

        // when : 어떤거를 실행할지
        // then : 이때 어떤 결과가 나타날지
        assertEquals(testAmount, commonMarketService.getPrice("bithumb",testCoin));

    }
}
