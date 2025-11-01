package com.zentry.sigea.modules.sesiones.core.repositories;

import java.util.List;
import java.util.Optional;

import com.zentry.sigea.modules.sesiones.core.entities.Inscripcion;

/**
 * Interfaz del repositorio de Inscripción (Capa de Dominio)
 * Define el contrato que debe implementar la infraestructura
 */
public interface IInscripcionRepository {
    
    Inscripcion save(Inscripcion inscripcion);
    
    Optional<Inscripcion> findById(Long id);
    
    List<Inscripcion> findByUsuarioId(Long usuarioId);
    
    List<Inscripcion> findByActividadId(Long actividadId);
    
    boolean existsByUsuarioIdAndActividadId(Long usuarioId, Long actividadId);
    
    void delete(Long id);
    
    List<Inscripcion> findAll();
}