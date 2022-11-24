package com.springbootpjt.myproject.feign.response;

import lombok.Getter;

@Getter
public class BithumResponse<T> {
    private String status;
    private T data;
}
