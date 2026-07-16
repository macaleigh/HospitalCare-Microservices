package com.ms_especialidades.ms_especialidades.controller;

import com.ms_especialidades.ms_especialidades.model.Especialidad;
import com.ms_especialidades.ms_especialidades.service.EspecialidadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping
    public ResponseEntity<List<Especialidad>> listar() {
        List<Especialidad> especialidades = especialidadService.findAll();
        if (especialidades.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(especialidades);
    }

    @PostMapping
    public ResponseEntity<Especialidad> guardar(@Valid @RequestBody Especialidad especialidad) {
        return ResponseEntity.status(HttpStatus.CREATED).body(especialidadService.save(especialidad));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Especialidad> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(especialidadService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Especialidad> actualizar(@PathVariable Integer id, @Valid @RequestBody Especialidad especialidad) {
        Especialidad esp = especialidadService.findById(id);
        esp.setNombre(especialidad.getNombre());
        esp.setDescripcion(especialidad.getDescripcion());
        especialidadService.save(esp);
        return ResponseEntity.ok(esp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        especialidadService.delete(id);
        return ResponseEntity.noContent().build();
    }
}