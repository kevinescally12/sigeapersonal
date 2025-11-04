package com.zentry.sigea.modules.sesiones.infrastructure.repositories.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zentry.sigea.modules.sesiones.infrastructure.database.entities.SesionEntity;

public interface SesionJpaRepository extends JpaRepository<SesionEntity, Long> {
}
