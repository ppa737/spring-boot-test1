package com.example.eurekaclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${server.port}")
    String port;
    @RequestMapping("/")
    public String home() {
        return "hello world from port " + port;
    }
}
