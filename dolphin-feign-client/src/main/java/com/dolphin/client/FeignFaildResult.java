package com.dolphin.client;

import lombok.Data;

@Data
public class FeignFaildResult {
    private String msg;
    private int code;
}