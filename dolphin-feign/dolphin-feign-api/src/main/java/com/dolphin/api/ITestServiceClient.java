package com.dolphin.api;

import org.springframework.web.bind.annotation.GetMapping;

public interface ITestServiceClient {
    /**
     * 服务调用测试方法
     * @return
     */
    @GetMapping("/test/method")
    public Response<String> testRequestMethod() throws Exception;

}
