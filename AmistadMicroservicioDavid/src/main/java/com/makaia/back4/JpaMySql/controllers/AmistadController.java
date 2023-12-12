package com.makaia.back4.JpaMySql.controllers;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.entities.Amistad;
import com.makaia.back4.JpaMySql.services.AmistadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/amistad")
public class AmistadController {
    private AmistadService service;

    @Autowired
    public AmistadController(AmistadService service) {
        this.service = service;
    }

    @PostMapping()
    public Amistad crear(@RequestBody CrearDTO dto) {
        return this.service.crear(dto);
    }

    @GetMapping()
    public List<Amistad> listarAmistades() {
        return this.service.listar();
    }

    @GetMapping("/{id}")
    public Amistad obtenerAmistad(@PathVariable Long id) {
        return this.service.obtener(id);
    }

    @PutMapping("/{id}")
    public Amistad actualizarAmistad(@PathVariable Long id, @RequestBody CrearDTO dto) {
        return this.service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarAmistad(@PathVariable Long id) {
        this.service.eliminar(id);
    }

    @PutMapping("/aceptar/{id}")
    public Amistad aceptarAmistad(@PathVariable Long id, @RequestBody CrearDTO dto) {
        return this.service.aceptarAmistad(id, dto);
    }
}