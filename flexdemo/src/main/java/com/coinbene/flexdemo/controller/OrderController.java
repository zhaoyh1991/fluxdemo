package com.coinbene.flexdemo.controller;


import com.coinbene.flexdemo.config.MessageReceiver;
import com.coinbene.flexdemo.entity.Order;
import com.coinbene.flexdemo.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@RestController
public class OrderController {
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    MessageReceiver messageReceiver;

    @RequestMapping(value = "/dealOrder")
    public Flux<Result> deal(Order order){
        //redisTemplate.convertAndSend("order",order.toString());
       Mono.fromCallable(()->{//异步发送
            redisTemplate.convertAndSend("order",order.toString());
            return "";
        }).subscribeOn(Schedulers.parallel()).subscribe();

        return  Flux.just(Result.sucess(System.currentTimeMillis()));
    }

}










