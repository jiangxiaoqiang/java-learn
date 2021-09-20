package com.dolphin.gateway.filter;

import org.springframework.beans.BeanUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dolphin
 */
@Component
public class CustomAddRequestHeaderGatewayFilterFactory implements GatewayFilterFactory<CustomAddRequestHeaderGatewayFilterFactory.CustomAddRequestHeaderConfig> {

    private final Class<CustomAddRequestHeaderConfig> configClass = CustomAddRequestHeaderConfig.class;

    @Override
    public List<String> shortcutFieldOrder() {
        return new ArrayList<>(Arrays.asList("headerName", "headerValue"));
    }

    @Override
    public GatewayFilter apply(CustomAddRequestHeaderConfig config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest().mutate().headers(httpHeaders -> {
                httpHeaders.set(config.getHeaderName(), config.getHeaderValue());
            }).build();
            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    @Override
    public ShortcutType shortcutType() {
        return ShortcutType.DEFAULT;
    }

    @Override
    public Class<CustomAddRequestHeaderConfig> getConfigClass() {
        return configClass;
    }

    @Override
    public CustomAddRequestHeaderConfig newConfig() {
        return BeanUtils.instantiateClass(this.configClass);
    }

    public static class CustomAddRequestHeaderConfig {

        private String headerName;
        private String headerValue;

        public String getHeaderName() {
            return headerName;
        }

        public void setHeaderName(String headerName) {
            this.headerName = headerName;
        }

        public String getHeaderValue() {
            return headerValue;
        }

        public void setHeaderValue(String headerValue) {
            this.headerValue = headerValue;
        }
    }
}
