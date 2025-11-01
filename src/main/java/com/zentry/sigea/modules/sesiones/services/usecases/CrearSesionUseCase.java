package com.zentry.sigea.modules.sesiones.services.usecases;

import com.zentry.sigea.modules.sesiones.core.entities.Sesion;
import com.zentry.sigea.modules.sesiones.core.repositories.ISesionRepository;
import org.springframework.stereotype.Service;

@Service
public class CrearSesionUseCase {
    private final ISesionRepository repository;

    public CrearSesionUseCase(ISesionRepository repository) {
        this.repository = repository;
    }

    public Sesion execute(Sesion sesion) {
        return repository.save(sesion);
    }
}

