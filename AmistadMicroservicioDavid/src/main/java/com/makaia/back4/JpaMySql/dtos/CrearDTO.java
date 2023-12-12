package com.makaia.back4.JpaMySql.dtos;

import java.util.Date;

public class CrearDTO {
    private boolean isAceptado;

    private Long solicitanteId;
    private Long solicitadoId;

    public CrearDTO(Long solicitanteId, Long solicitadoId, boolean isAceptado) {
        this.solicitanteId = solicitanteId;
        this.solicitadoId = solicitadoId;
        this.isAceptado = isAceptado;
    }

    public boolean isAceptado() {
        return isAceptado;
    }

    public void setAceptado(boolean aceptado) {
        isAceptado = aceptado;
    }

    public Long getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(Long solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public Long getSolicitadoId() {
        return solicitadoId;
    }

    public void setSolicitadoId(Long solicitadoId) {
        this.solicitadoId = solicitadoId;
    }
}


//    private Date desde;
//    private Long usuarioId;

//    public CrearDTO(boolean isAceptado, Date desde, Long usuarioId) {
//        this.isAceptado = isAceptado;
//        this.desde = desde;
//        this.usuarioId = usuarioId;
//    }
//
//    public boolean isAceptado() {
//        return isAceptado;
//    }
//
//    public void setAceptado(boolean aceptado) {
//        isAceptado = aceptado;
//    }
//
//    public Date getDesde() {
//        return desde;
//    }
//
//    public void setDesde(Date desde) {
//        this.desde = desde;
//    }
//
//    public Long getUsuarioId() {
//        return usuarioId;
//    }
//
//    public void setUsuarioId(Long usuarioId) {
//        this.usuarioId = usuarioId;
//    }
