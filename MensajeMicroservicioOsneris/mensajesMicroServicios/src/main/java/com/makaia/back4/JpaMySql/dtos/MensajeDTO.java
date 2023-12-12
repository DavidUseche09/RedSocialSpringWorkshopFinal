package com.makaia.back4.JpaMySql.dtos;

public class MensajeDTO {

        private String contenido;
        private Long emisorId;
        private Long receptorId;

        public MensajeDTO() {
        }

        public MensajeDTO(String contenido, Long emisorId, Long receptorId) {
            this.contenido = contenido;
            this.emisorId = emisorId;
            this.receptorId = receptorId;
        }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getEmisorId() {
        return emisorId;
    }

    public void setEmisorId(Long emisorId) {
        this.emisorId = emisorId;
    }

    public Long getReceptorId() {
        return receptorId;
    }

    public void setReceptorId(Long receptorId) {
        this.receptorId = receptorId;
    }
}
