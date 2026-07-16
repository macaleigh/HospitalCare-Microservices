package com.ms_hospitalizacion.ms_hospitalizacion.controller;

import com.ms_hospitalizacion.ms_hospitalizacion.model.Hospitalizacion;
import com.ms_hospitalizacion.ms_hospitalizacion.service.HospitalizacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitalizaciones")
public class HospitalizacionController {

    @Autowired
    private HospitalizacionService hospitalizacionService;

    @GetMapping
    public ResponseEntity<List<Hospitalizacion>> listar() {
        List<Hospitalizacion> lista = hospitalizacionService.findAll();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<Hospitalizacion> guardar(@Valid @RequestBody Hospitalizacion hospitalizacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hospitalizacionService.save(hospitalizacion));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospitalizacion> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(hospitalizacionService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospitalizacion> actualizar(@PathVariable Integer id, @Valid @RequestBody Hospitalizacion hospitalizacion) {
        Hospitalizacion h = hospitalizacionService.findById(id);
        h.setPacienteId(hospitalizacion.getPacienteId());
        h.setHabitacion(hospitalizacion.getHabitacion());
        h.setFechaIngreso(hospitalizacion.getFechaIngreso());
        h.setFechaAlta(hospitalizacion.getFechaAlta());
        h.setMotivo(hospitalizacion.getMotivo());
        hospitalizacionService.save(h);
        return ResponseEntity.ok(h);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        hospitalizacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}