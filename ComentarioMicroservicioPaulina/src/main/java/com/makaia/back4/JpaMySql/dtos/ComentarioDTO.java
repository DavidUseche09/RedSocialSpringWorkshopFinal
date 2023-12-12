package com.makaia.back4.JpaMySql.dtos;

public class ComentarioDTO {
    private String contenido;
    private Long usuario;
    private Long publicacion;

    public ComentarioDTO() {
    }

    public ComentarioDTO(String contenido, Long usuario, long publicacion) {
        this.contenido = contenido;
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(Long usuario) {
        this.usuario = usuario;
    }

    public Long getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Long publicacion) {
        this.publicacion = publicacion;
    }

    @Override
    public String toString() {
        return "ComentarioDTO{" +
                "contenido='" + contenido + '\'' +
                ", usuario=" + usuario +
                ", publicacion=" + publicacion +
                '}';
    }
}