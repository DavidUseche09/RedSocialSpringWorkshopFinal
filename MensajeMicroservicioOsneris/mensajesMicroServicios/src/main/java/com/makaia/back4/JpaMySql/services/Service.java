package com.makaia.back4.JpaMySql.services;

import com.makaia.back4.JpaMySql.dtos.MensajeDTO;
import com.makaia.back4.JpaMySql.entities.Mensaje;
import com.makaia.back4.JpaMySql.entities.Usuario;
import com.makaia.back4.JpaMySql.repositories.MensajeRepository;
import com.makaia.back4.JpaMySql.repositories.UsuarioRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.Optional;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class Service {
    private final AmqpTemplate amqpTemplate;
    private final MensajeRepository mensajeRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public Service(AmqpTemplate amqpTemplate, MensajeRepository mensajeRepository, UsuarioRepository usuarioRepository) {
        this.amqpTemplate = amqpTemplate;
        this.mensajeRepository = mensajeRepository;
        this.usuarioRepository = usuarioRepository;
    }


    public  Mensaje enviarMensaje(MensajeDTO mensajeDTO) {
        Usuario emisor = usuarioRepository.findById(mensajeDTO.getEmisorId())
                .orElseThrow(() -> new RuntimeException("Usuario emisor no encontrado"));

        Usuario receptor = usuarioRepository.findById(mensajeDTO.getReceptorId())
                .orElseThrow(() -> new RuntimeException("Usuario receptor no encontrado"));

        Mensaje mensaje = new Mensaje();
        mensaje.setContenido(mensajeDTO.getContenido());
        mensaje.setEmisor(emisor);
        mensaje.setReceptor(receptor);


        mensajeRepository.save(mensaje);

        // Enviar mensaje a RabbitMQ
        amqpTemplate.convertAndSend("m intercambiar", "clav direccion", mensajeDTO);

        return mensaje;
    }

    public Mensaje listar() {
        return (Mensaje) StreamSupport
                .stream(this.mensajeRepository.findAll().spliterator(),false);

    }



    public Optional<Mensaje> obtenerMensajePorId(Long id) {
        return mensajeRepository.findById(id);
    }
    public void eliminarMensaje(Long id) {
        mensajeRepository.deleteById(id);
    }



}