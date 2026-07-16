package com.ms_examenes.ms_examenes.controller;

import com.ms_examenes.ms_examenes.model.Examen;
import com.ms_examenes.ms_examenes.service.ExamenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/examenes")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    @GetMapping
    public ResponseEntity<List<Examen>> listar() {
        List<Examen> examenes = examenService.findAll();
        if (examenes.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(examenes);
    }

    @PostMapping
    public ResponseEntity<Examen> guardar(@Valid @RequestBody Examen examen) {
        return ResponseEntity.status(HttpStatus.CREATED).body(examenService.save(examen));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Examen> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(examenService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Examen> actualizar(@PathVariable Integer id, @Valid @RequestBody Examen examen) {
        Examen e = examenService.findById(id);
        e.setPacienteId(examen.getPacienteId());
        e.setTipoExamen(examen.getTipoExamen());
        e.setResultado(examen.getResultado());
        e.setFechaExamen(examen.getFechaExamen());
        examenService.save(e);
        return ResponseEntity.ok(e);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        examenService.delete(id);
        return ResponseEntity.noContent().build();
    }
}