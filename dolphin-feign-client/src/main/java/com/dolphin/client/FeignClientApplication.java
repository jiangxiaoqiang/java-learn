package main.java.com.dolphin.client;

@SpringBootApplication(exclude = {

})
public class FeignClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringLearn.class, args);
    }

    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }
}