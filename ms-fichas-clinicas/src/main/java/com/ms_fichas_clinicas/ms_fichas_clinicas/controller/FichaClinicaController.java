package com.ms_fichas_clinicas.ms_fichas_clinicas.controller;

import com.ms_fichas_clinicas.ms_fichas_clinicas.model.FichaClinica;
import com.ms_fichas_clinicas.ms_fichas_clinicas.service.FichaClinicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fichas-clinicas")
public class FichaClinicaController {

    @Autowired
    private FichaClinicaService fichaClinicaService;

    @GetMapping
    public ResponseEntity<List<FichaClinica>> listar() {
        List<FichaClinica> fichas = fichaClinicaService.findAll();
        if (fichas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(fichas);
    }

    @PostMapping
    public ResponseEntity<FichaClinica> guardar(@Valid @RequestBody FichaClinica ficha) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fichaClinicaService.save(ficha));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FichaClinica> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(fichaClinicaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FichaClinica> actualizar(@PathVariable Integer id, @Valid @RequestBody FichaClinica ficha) {
        FichaClinica f = fichaClinicaService.findById(id);
        f.setPacienteId(ficha.getPacienteId());
        f.setDiagnostico(ficha.getDiagnostico());
        f.setObservaciones(ficha.getObservaciones());
        f.setFechaCreacion(ficha.getFechaCreacion());
        fichaClinicaService.save(f);
        return ResponseEntity.ok(f);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        fichaClinicaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}