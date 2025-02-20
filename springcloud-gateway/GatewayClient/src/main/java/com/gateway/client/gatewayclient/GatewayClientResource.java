package com.gateway.client.gatewayclient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/gateway-client/client")
public class GatewayClientResource {


    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback", groupKey = "Hello",
            commandKey = "hello",
            threadPoolKey = "helloThread"
            )
    @GetMapping
    public String hello() {
        String url = "http://Gateway-Server/rest/gateway-server/server";
        return restTemplate.getForObject(url, String.class);
    }

    public String fallback(Throwable hystrixCommand) {
        return "Fall Back Hello world";
    }

}
