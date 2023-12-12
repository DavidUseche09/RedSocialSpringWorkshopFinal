package com.makaia.back4.JpaMySql.publisher;

import com.makaia.back4.JpaMySql.dtos.MensajeDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
    private final AmqpTemplate amqpTemplate;

    @Autowired
    public Publisher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void publicarMensaje(MensajeDTO mensajeDTO) {
        // Enviar el mensaje al intercambio con la clave de enrutamiento
        amqpTemplate.convertAndSend("nombre_de_tu_intercambio", "clave", mensajeDTO);
    }
}