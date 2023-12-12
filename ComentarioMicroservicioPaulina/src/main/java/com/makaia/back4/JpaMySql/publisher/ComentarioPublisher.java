package com.makaia.back4.JpaMySql.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComentarioPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue comentarioQueue;

    @Autowired
    public ComentarioPublisher(RabbitTemplate rabbitTemplate, Queue comentarioQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.comentarioQueue = comentarioQueue;
    }

    public void enviarMensaje(Long comentarioId) {
        rabbitTemplate.convertAndSend(comentarioQueue.getName(), comentarioId);
        System.out.println("Mensaje enviado para el comentario con ID: " + comentarioId);
    }
}