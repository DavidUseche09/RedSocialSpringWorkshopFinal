//package com.makaia.back4.JpaMySql.consumer;
//
//import com.makaia.back4.JpaMySql.dtos.MensajeDTO;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//@EnableRabbit
//public class Consumer {
//
//    private final Service mensajeService;
//    @Autowired
//    Service mensajeService;
//
//    @RabbitListener(queues = {"message_created"}) // message_created: Nombre de la cola que se quiere escuchar
//    public void recibirMensaje(MensajeDTO crearDTO) {
//        // Procesar el mensaje recibido
//        mensajeService.enviarMensaje(crearDTO);
//
//    }
//}


