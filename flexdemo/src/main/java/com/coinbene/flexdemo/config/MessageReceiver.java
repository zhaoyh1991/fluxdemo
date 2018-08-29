package com.coinbene.flexdemo.config;



import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

/**redis 消息处理器*/

@Component

public class MessageReceiver {


    /**接收消息的方法*/
    public void receiveMessage(String message){

        Flux<Object> objectFlux = Flux.create(fluxSink -> {
            fluxSink.next(message);
        });
        objectFlux.subscribe(o->{

                try {

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(o);
                System.out.println(System.currentTimeMillis());

        });
    }

}
