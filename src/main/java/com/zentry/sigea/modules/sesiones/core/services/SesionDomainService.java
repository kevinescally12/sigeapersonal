package com.zentry.sigea.modules.sesiones.core.services;

import com.zentry.sigea.modules.sesiones.core.entities.Sesion;
import com.zentry.sigea.modules.sesiones.core.repositories.ISesionRepository;

import java.util.List;

public class SesionDomainService {

    private final ISesionRepository repository;

    public SesionDomainService(ISesionRepository repository) {
        this.repository = repository;
    }

    public Sesion crear(Sesion s) {
        return repository.save(s);
    }

    public List<Sesion> listar() {
        return repository.findAll();
    }
}
