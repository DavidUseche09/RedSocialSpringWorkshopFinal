package com.makaia.back4.JpaMySql.repositories;

import com.makaia.back4.JpaMySql.entities.Amistad;
import com.makaia.back4.JpaMySql.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmistadRepository extends CrudRepository<Amistad, Long> {
    Amistad findBySolicitanteAndSolicitado(Usuario solicitanteId, Usuario solicitadoId);
}
