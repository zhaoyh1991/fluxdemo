package com.coinbene.flexdemo;

import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class FluxTest {
    public static void main(String[] args) {
        AtomicInteger a=new AtomicInteger(0);
        Flux<Integer> generate = Flux.generate(synchronousSink -> {
            synchronousSink.next(new Integer(a.getAndIncrement()));
            if(a.get()==6){
                synchronousSink.complete();
            }
            if (a.get()==3){
                synchronousSink.error(new Exception("error"));
            }

        });

        generate.onErrorReturn(111111).subscribe(System.out::println,t->{t.printStackTrace();},()->{
            System.out.println("complete");
        });

    }


}
