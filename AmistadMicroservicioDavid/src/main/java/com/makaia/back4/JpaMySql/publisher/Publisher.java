package com.makaia.back4.JpaMySql.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue amistadQueue;

    public void sendAmistadCreada(Long amistadId) {
        this.rabbitTemplate.convertAndSend(amistadQueue.getName(), amistadId);
    }
}
