package com.zentry.sigea.modules.sesiones.infrastructure.database.entities;
import java.time.LocalDateTime;

public class SesionEntity {

    private Long id;
    private String titulo;
    private LocalDateTime fechaInicio;
    public SesionEntity() {}

    public SesionEntity(Long id, String titulo, LocalDateTime fechaInicio) {
        this.id = id;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }
}
