package com.dolphin.server.api;

import com.dolphin.api.ITestServiceClient;
import com.dolphin.api.Response;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class FeignController implements ITestServiceClient {

    @Override
    public Response<String> testRequestMethod() throws Exception {
        throw new ServiceException(1234,"bakakkddd");
    }
}
