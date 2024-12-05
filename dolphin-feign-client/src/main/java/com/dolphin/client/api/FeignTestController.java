package com.dolphin.client.api;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class FeignTestController {

    @Resource
    private ITestServiceClient client;

    @GetMapping("/test")
    @Operation(summary = "获得API 访问日志分页")
    public void getApiAccessLogPage() throws Exception {
         client.testRequestMethod();
    }

}
