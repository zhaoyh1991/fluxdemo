package com.coinbene.flexdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


//这是第一种基于注解的方式
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public Mono<String> hello(){//return type change
        return Mono.just("hello");
    }

}
