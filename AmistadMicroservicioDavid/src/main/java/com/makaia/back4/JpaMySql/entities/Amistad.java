package com.makaia.back4.JpaMySql.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Amistad {
//    private Usuario usuario;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private boolean isAceptado;

    @Column(nullable = true)
    private Date desde;

    @ManyToOne(optional = false)
    Usuario solicitante;

    @ManyToOne(optional = false)
    Usuario solicitado;

    public Amistad() {
    }

    public Amistad(boolean isAceptado, Date desde, Usuario usuario) {
        this.isAceptado = isAceptado;
        this.desde = desde;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAceptado() {
        return isAceptado;
    }

    public void setAceptado(boolean aceptado) {
        isAceptado = aceptado;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public Usuario getSolicitado() {
        return solicitado;
    }

    public void setSolicitado(Usuario solicitado) {
        this.solicitado = solicitado;
    }
}
