package com.ms_recetas.ms_recetas.controller;

import com.ms_recetas.ms_recetas.model.Receta;
import com.ms_recetas.ms_recetas.service.RecetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/recetas")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping
    public ResponseEntity<List<Receta>> listar() {
        List<Receta> recetas = recetaService.findAll();
        if (recetas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(recetas);
    }

    @PostMapping
    public ResponseEntity<Receta> guardar(@Valid @RequestBody Receta receta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(recetaService.save(receta));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receta> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(recetaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receta> actualizar(@PathVariable Integer id, @Valid @RequestBody Receta receta) {
        Receta r = recetaService.findById(id);
        r.setPacienteId(receta.getPacienteId());
        r.setMedicoId(receta.getMedicoId());
        r.setMedicamento(receta.getMedicamento());
        r.setDosis(receta.getDosis());
        r.setFechaEmision(receta.getFechaEmision());
        recetaService.save(r);
        return ResponseEntity.ok(r);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        recetaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}