package com.zentry.sigea.modules.sesiones.presentacion.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * DTO para la solicitud de registro de inscripción
*/
public class RegistrarInscripcionRequest {
    
    @NotNull(message = "El ID del usuario es obligatorio")
    @Positive(message = "El ID del usuario debe ser positivo")
    private Long usuarioId;
    
    @NotNull(message = "El ID de la actividad es obligatorio")
    @Positive(message = "El ID de la actividad debe ser positivo")
    private Long actividadId;

    public RegistrarInscripcionRequest() {
    }

    public RegistrarInscripcionRequest(Long usuarioId, Long actividadId) {
        this.usuarioId = usuarioId;
        this.actividadId = actividadId;
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
}