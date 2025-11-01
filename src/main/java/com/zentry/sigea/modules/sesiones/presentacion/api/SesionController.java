package com.zentry.sigea.modules.sesiones.presentacion.api;

import com.zentry.sigea.modules.sesiones.core.entities.Sesion;
import com.zentry.sigea.modules.sesiones.services.usecases.CrearSesionUseCase;
import com.zentry.sigea.modules.sesiones.services.usecases.ListarSesionesUseCase;
import com.zentry.sigea.modules.sesiones.services.usecases.ActualizarSesionUseCase;
import com.zentry.sigea.modules.sesiones.services.usecases.EliminarSesionUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/sesiones")
public class SesionController {
    private final CrearSesionUseCase crearUseCase;
    private final ListarSesionesUseCase listarUseCase;
    private final ActualizarSesionUseCase actualizarUseCase;
    private final EliminarSesionUseCase eliminarUseCase;

    public SesionController(CrearSesionUseCase crearUseCase, ListarSesionesUseCase listarUseCase,
                            ActualizarSesionUseCase actualizarUseCase, EliminarSesionUseCase eliminarUseCase) {
        this.crearUseCase = crearUseCase;
        this.listarUseCase = listarUseCase;
        this.actualizarUseCase = actualizarUseCase;
        this.eliminarUseCase = eliminarUseCase;
    }

    @PostMapping
    public ResponseEntity<SesionDTO> crear(@RequestBody SesionRequest request) {
        Sesion domain = Sesion.create(request.getActividadId(), request.getFechaSesion(), request.getTitulo());
        var saved = crearUseCase.execute(domain);
        var dto = new SesionDTO(saved.getId(), saved.getActividadId(), saved.getFechaSesion(), saved.getTitulo());
        return ResponseEntity.created(URI.create("/api/sesiones/" + dto.getId())).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<SesionDTO>> listar() {
        var list = listarUseCase.execute();
        List<SesionDTO> dtos = list.stream().map(s -> new SesionDTO(s.getId(), s.getActividadId(), s.getFechaSesion(), s.getTitulo())).toList();
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SesionDTO> actualizar(@PathVariable Long id, @RequestBody SesionRequest request) {
        Sesion updated = Sesion.create(request.getActividadId(), request.getFechaSesion(), request.getTitulo());
        var result = actualizarUseCase.execute(id, updated);
        return result.map(s -> new ResponseEntity<>(new SesionDTO(s.getId(), s.getActividadId(), s.getFechaSesion(), s.getTitulo()), org.springframework.http.HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        eliminarUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}

