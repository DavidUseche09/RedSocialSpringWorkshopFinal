package com.makaia.back4.JpaMySql.consumer;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class AmistadConsumer {
    @RabbitListener(queues = "amistad_created")
    public void recibirNotificacionAmistad(@Payload Long id) {
        System.out.println("Amistad creada" + id);
    }

}
