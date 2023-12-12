package com.makaia.back4.JpaMySql.services;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.entities.Amistad;
import com.makaia.back4.JpaMySql.entities.Usuario;
import com.makaia.back4.JpaMySql.exceptions.RedSocialApiException;
import com.makaia.back4.JpaMySql.publisher.Publisher;
import com.makaia.back4.JpaMySql.repositories.AmistadRepository;
import com.makaia.back4.JpaMySql.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class AmistadService {
    AmistadRepository repository;
    Publisher publisher;
    UsuarioRepository usuarioRepository;

    @Autowired
    public AmistadService(AmistadRepository repository, Publisher publisher, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.publisher = publisher;
        this.usuarioRepository = usuarioRepository;
    }
    public Amistad crear(CrearDTO dto) {
        Usuario solicitante = obtenerUsuarioPorId(dto.getSolicitanteId());
        Usuario solicitado = obtenerUsuarioPorId(dto.getSolicitadoId());

        validarAmistadNoExistente(solicitante, solicitado);

        Amistad nuevaAmistad = new Amistad();
        nuevaAmistad.setSolicitante(solicitante);
        nuevaAmistad.setSolicitado(solicitado);
        nuevaAmistad.setAceptado(false);

        nuevaAmistad = this.repository.save(nuevaAmistad);

        this.publisher.sendAmistadCreada(nuevaAmistad.getId());
        return nuevaAmistad;
    }
    private Usuario obtenerUsuarioPorId(Long usuarioId) {
        return this.usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RedSocialApiException("Usuario no encontrado con ID: " + usuarioId));
    }

    private void validarAmistadNoExistente(Usuario solicitante, Usuario solicitado) {
        if (existeAmistad(solicitante, solicitado) || existeAmistad(solicitado, solicitante)) {
            throw new RedSocialApiException("Ya existe una amistad entre los usuarios.");
        }
    }

    private boolean existeAmistad(Usuario usuario1, Usuario usuario2) {
        return false;
    }
    public List<Amistad> listar() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }

    public Amistad obtener(Long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new RedSocialApiException("Amistad no encontrada con ID: " + id));
    }

    public Amistad actualizar(Long id, CrearDTO dto) {
        Amistad amistadExistente = obtener(id);

        amistadExistente.setAceptado(dto.isAceptado());
        return this.repository.save(amistadExistente);
    }

    public void eliminar(Long id) {
        Amistad amistadExistente = obtener(id);
        this.repository.delete(amistadExistente);
    }

    public Amistad aceptarAmistad(Long solicitanteId, CrearDTO dto) {
        Amistad amistadPendiente = repository
                .findBySolicitanteAndSolicitado(new Usuario(solicitanteId), new Usuario(dto.getSolicitadoId()));

        if (amistadPendiente != null) {
            amistadPendiente.setAceptado(true);
            return repository.save(amistadPendiente);
        } else {
            throw new RedSocialApiException("No se encontró ninguna solicitud de amistad pendiente para aceptar.");
        }
    }
}




//    public Amistad crearAmistad(CrearDTO dto) {
//        Usuario usuario = this.usuarioRepository.findById(dto.getUsuarioId())
//                .orElseThrow(
//                        () -> new RedSocialApiException("User not found")
//                );
//        Amistad nuevaAmistad = new Amistad(dto.isAceptado(),dto.getDesde(),usuario);
//        return this.repository.save(nuevaAmistad);
//    }
