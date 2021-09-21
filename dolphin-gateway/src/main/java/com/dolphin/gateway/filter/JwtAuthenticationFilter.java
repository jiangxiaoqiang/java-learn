package com.dolphin.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author dolphin
 */
@Component
@Slf4j
public class JwtAuthenticationFilter implements GlobalFilter, Ordered {

    @Value("${dolphin.gateway.jwt.verify:true}")
    private boolean jwtVerify;

    final static List<String> apiEndpoints = List.of("/register", "/login");
    final static Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
            .noneMatch(uri -> r.getURI().getPath().contains(uri));

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if(!jwtVerify){
            return chain.filter(exchange);
        }
        if(exchange.getRequest() instanceof ServletServerHttpRequest){
            ServletServerHttpRequest request = (ServletServerHttpRequest) exchange.getRequest();
            if (isApiSecured.test(request)) {
                return authImpl(request,exchange,chain);
            }
        }else{
            log.error("request not a ServletServerHttpRequest");
        }
        return chain.filter(exchange);
    }

    private Mono<Void> authImpl(ServletServerHttpRequest request,ServerWebExchange exchange,GatewayFilterChain chain){
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
