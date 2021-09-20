package com.dolphin.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @author dolphin
 */
@Component
public class DemoGatewayFilter extends AbstractGatewayFilterFactory {

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            return chain.filter(exchange);
        };
/*
it works too
       return new GatewayFilter() {
           @Override
           public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
               return chain.filter(exchange);
           }
       }
*/
    }

}