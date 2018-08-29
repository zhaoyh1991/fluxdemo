package com.coinbene.flexdemo.config;

import com.coinbene.flexdemo.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {
    @Autowired
    private TimeHandler timeHandler;

    @Bean
    public RouterFunction<ServerResponse> timeRouter(){
        return RouterFunctions.route(RequestPredicates.GET("/getTime"),timeHandler::getTime)
                .andRoute(RequestPredicates.GET("/times"),timeHandler::times);
    }


}
