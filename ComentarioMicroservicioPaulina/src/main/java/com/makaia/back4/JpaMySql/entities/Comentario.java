package com.makaia.back4.JpaMySql.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String contenido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario_id", nullable = false)
    Usuario usuario;

    @ManyToOne(optional = false)
    @JoinColumn(name = "publicacion_id", nullable = false)
    Publicacion publicacion;

    public Long getId() {
        return id;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }

}