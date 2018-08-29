package com.coinbene.flexdemo.handler;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

@Component
public class TimeHandler {


    public Mono<ServerResponse> getTime(ServerRequest serverRequest){
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(Mono.just("now is "+ Calendar.getInstance().getTime()),String.class);
    }

    public Mono<ServerResponse> times(ServerRequest serverRequest){
        Mono<ServerResponse> body = ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM)
                .body(
                        Flux.interval(Duration.ofSeconds(1)).
                                map(l -> new SimpleDateFormat("HH:mm:ss").format(new Date())),
                        String.class);

        return body;
    }

}
