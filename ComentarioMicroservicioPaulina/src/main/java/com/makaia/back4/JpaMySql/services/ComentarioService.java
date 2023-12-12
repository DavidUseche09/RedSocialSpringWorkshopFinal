package com.makaia.back4.JpaMySql.services;

import com.makaia.back4.JpaMySql.dtos.ComentarioDTO;
import com.makaia.back4.JpaMySql.entities.Comentario;
import com.makaia.back4.JpaMySql.entities.Publicacion;
import com.makaia.back4.JpaMySql.entities.Usuario;
import com.makaia.back4.JpaMySql.exceptions.RedSocialApiException;
import com.makaia.back4.JpaMySql.repositories.ComentarioRepository;
import com.makaia.back4.JpaMySql.repositories.PublicacionRepository;
import com.makaia.back4.JpaMySql.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final PublicacionRepository publicacionRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ComentarioService(ComentarioRepository comentarioRepository, PublicacionRepository publicacionRepository,
            UsuarioRepository usuarioRepository) {
        this.comentarioRepository = comentarioRepository;
        this.publicacionRepository = publicacionRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Comentario crearComentario(ComentarioDTO comentarioDTO) {

        Publicacion publicacion = publicacionRepository.findById(comentarioDTO.getPublicacion())
                .orElseThrow(() -> new RedSocialApiException("La publicación no existe"));

        Usuario usuario = usuarioRepository.findById(comentarioDTO.getUsuario())
                .orElseThrow(() -> new RedSocialApiException("El usuario no existe"));

        Comentario comentario = new Comentario();
        comentario.setUsuario(usuario);
        comentario.setPublicacion(publicacion);
        comentario.setContenido(comentarioDTO.getContenido());

        return comentarioRepository.save(comentario);
    }

    public List<Comentario> obtenerComentarios() {
        return comentarioRepository.findAll();
    }

    public List<Comentario> obtenerComentariosPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RedSocialApiException("El usuario no existe"));
        return comentarioRepository.findByUsuarioId(usuario);
    }

    public List<Comentario> obtenerComentariosPorPublicacion(Long publicacionId) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new RedSocialApiException("La publicación no existe"));
        return comentarioRepository.findByPublicacionId(publicacion);
    }

    public void eliminarComentario(Long comentarioId) {
        comentarioRepository.deleteById(comentarioId);

    }

    public Comentario editarComentario(Long comentarioId, ComentarioDTO comentarioDTO) {
        Comentario comentario = comentarioRepository.findById(comentarioId)
                .orElseThrow(() -> new RedSocialApiException("El comentario no existe"));

        Publicacion publicacion = publicacionRepository.findById(comentarioDTO.getPublicacion())
                .orElseThrow(() -> new RedSocialApiException("La publicación no existe"));

        Usuario usuario = usuarioRepository.findById(comentarioDTO.getUsuario())
                .orElseThrow(() -> new RedSocialApiException("El usuario no existe"));

        comentario.setUsuario(usuario);
        comentario.setPublicacion(publicacion);
        comentario.setContenido(comentarioDTO.getContenido());

        return comentarioRepository.save(comentario);
    }

}