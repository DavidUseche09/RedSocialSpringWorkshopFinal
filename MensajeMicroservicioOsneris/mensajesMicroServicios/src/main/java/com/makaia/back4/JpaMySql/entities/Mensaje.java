package com.makaia.back4.JpaMySql.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String contenido;

    @ManyToOne(optional = false)
    Usuario emisor;

    @ManyToOne(optional = false)
    Usuario receptor;

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }
}
