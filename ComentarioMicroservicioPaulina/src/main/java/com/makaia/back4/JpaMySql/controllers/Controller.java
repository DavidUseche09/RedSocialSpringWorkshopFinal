package com.makaia.back4.JpaMySql.controllers;

import com.makaia.back4.JpaMySql.dtos.ComentarioDTO;
import com.makaia.back4.JpaMySql.entities.Comentario;
import com.makaia.back4.JpaMySql.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comentarios")

public class Controller {
    private ComentarioService service;

    @Autowired
    public Controller(ComentarioService service) {
        this.service = service;
    }

    @PostMapping()
    public Comentario crearComentario(@RequestBody ComentarioDTO dto) {
        System.out.println(dto);
        return this.service.crearComentario(dto);
    }

    @GetMapping()
    public List<Comentario> listarComentarios() {
        return this.service.obtenerComentarios();
    }

    @DeleteMapping("/{comentarioId}")
    public void eliminarComentario(@PathVariable Long comentarioId) {
        this.service.eliminarComentario(comentarioId);
    }

    @PutMapping("/{comentarioId}")
    public Comentario editarComentario(@PathVariable Long comentarioId, @RequestBody ComentarioDTO dto) {
        return this.service.editarComentario(comentarioId, dto);
    }

}
