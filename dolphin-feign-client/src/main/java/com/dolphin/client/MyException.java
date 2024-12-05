package com.dolphin.client;

import lombok.Data;

@Data
public class MyException extends RuntimeException {
    // 自定义异常代码
    private int status = 503;

    public MyException() {

    }

    // 构造方法
    public MyException(String message, int status) {
        super(message);
        this.status = status;
    }
}

