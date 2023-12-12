package com.makaia.back4.JpaMySql.controllers;

import com.makaia.back4.JpaMySql.dtos.MensajeDTO;
import com.makaia.back4.JpaMySql.entities.Mensaje;
import com.makaia.back4.JpaMySql.exceptions.RedSocialApiException;
import com.makaia.back4.JpaMySql.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/mensajes")
public class Controller {
    private Service service;


    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    public List<Mensaje> listarMensajes() {
        return Collections.singletonList(this.service.listar());
    }

    @PostMapping
    public Mensaje enviarMensaje(@RequestBody MensajeDTO crearDTO) {
        return this.service.enviarMensaje(crearDTO);
    }



    @GetMapping("/{id}")
    public Mensaje obtenerMensajePorId(@PathVariable Long id) {
        return service.obtenerMensajePorId(id)
                .orElseThrow(() -> new RedSocialApiException("Mensaje no encontrado"));
    }
    @DeleteMapping("/{id}")
    public void eliminarMensaje(@PathVariable Long id) {
        service.eliminarMensaje(id);
    }

}