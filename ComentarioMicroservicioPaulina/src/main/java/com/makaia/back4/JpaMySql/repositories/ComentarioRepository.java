package com.makaia.back4.JpaMySql.repositories;

import com.makaia.back4.JpaMySql.entities.Comentario;
import com.makaia.back4.JpaMySql.entities.Publicacion;
import com.makaia.back4.JpaMySql.entities.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    List<Comentario> findByUsuarioId(Usuario usuario);

    List<Comentario> findByPublicacionId(Publicacion publicacion);
}
