package com.zentry.sigea.modules.sesiones.core.entities;

import java.time.LocalDate;

/**
 * Entidad de dominio para Inscripción
 * Representa el registro de un usuario a una actividad
 * Esta clase NO tiene anotaciones JPA - es una entidad de dominio pura
 */
public class Inscripcion {
    private Long id;
    private Long usuarioId;
    private Long actividadId;
    private LocalDate fechaInscripcion;
    private Long estadoInscripcionId;

    public Inscripcion() {
    }

    public Inscripcion(Long id, Long usuarioId, Long actividadId, 
                       LocalDate fechaInscripcion, Long estadoInscripcionId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.actividadId = actividadId;
        this.fechaInscripcion = fechaInscripcion;
        this.estadoInscripcionId = estadoInscripcionId;
    }


    public static Inscripcion crearNuevaInscripcion(Long usuarioId, Long actividadId, Long estadoInscripcionId) {
        return new Inscripcion(
            null, 
            usuarioId, 
            actividadId, 
            LocalDate.now(),
            estadoInscripcionId != null ? estadoInscripcionId : 1L
        );
    }

    // Lógica de negocio: validar que la inscripción es válida
    public boolean esValida() {
        return usuarioId != null && actividadId != null && fechaInscripcion != null && estadoInscripcionId != null;
    }

    // Lógica de negocio: cambiar estado
    public void cambiarEstado(Long nuevoEstadoId) {
        if (nuevoEstadoId == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }
        this.estadoInscripcionId = nuevoEstadoId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getActividadId() {
        return actividadId;
    }

    public void setActividadId(Long actividadId) {
        this.actividadId = actividadId;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Long getEstadoInscripcionId() {
        return estadoInscripcionId;
    }

    public void setEstadoInscripcionId(Long estadoInscripcionId) {
        this.estadoInscripcionId = estadoInscripcionId;
    }
}