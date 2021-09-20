package com.dolphin.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @author dolphin
 */
@Component
public class LogFilter2GatewayFilterFactory extends AbstractGatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange,chain) -> {
            System.out.println("LogFilter2 flitered!!!");
            return chain.filter(exchange);
        };
    }
}