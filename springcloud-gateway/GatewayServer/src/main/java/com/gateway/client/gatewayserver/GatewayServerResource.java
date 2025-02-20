package com.gateway.client.gatewayserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/gateway-server/server")
public class GatewayServerResource {

    @GetMapping
    public String hello() {
        return "Hello World!";
    }
}
