package com.dolphin.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

/**
 * @author dolphin
 */
@Slf4j
@Component
public class RequestLogGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {
    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return (exchange,  chain)-> {
            log.info("请求网关：{}，{}",config.getName(),config.getValue());
            MultiValueMap<String,String> params = exchange.getRequest().getQueryParams();
            params.forEach((k,v)->{
                log.info("请求参数：{}，请求参数值：{}",k, StringUtils.join(v,","));
            });
            return chain.filter(exchange).then();
        };
    }
}
