package com.ms_urgencias.ms_urgencias.controller;

import com.ms_urgencias.ms_urgencias.model.Urgencia;
import com.ms_urgencias.ms_urgencias.service.UrgenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/urgencias")
public class UrgenciaController {

    @Autowired
    private UrgenciaService urgenciaService;

    @GetMapping
    public ResponseEntity<List<Urgencia>> listar() {
        List<Urgencia> urgencias = urgenciaService.findAll();
        if (urgencias.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(urgencias);
    }

    @PostMapping
    public ResponseEntity<Urgencia> guardar(@Valid @RequestBody Urgencia urgencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(urgenciaService.save(urgencia));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Urgencia> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(urgenciaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Urgencia> actualizar(@PathVariable Integer id, @Valid @RequestBody Urgencia urgencia) {
        Urgencia u = urgenciaService.findById(id);
        u.setPacienteId(urgencia.getPacienteId());
        u.setPrioridad(urgencia.getPrioridad());
        u.setSintomas(urgencia.getSintomas());
        u.setFechaAtencion(urgencia.getFechaAtencion());
        urgenciaService.save(u);
        return ResponseEntity.ok(u);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        urgenciaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}