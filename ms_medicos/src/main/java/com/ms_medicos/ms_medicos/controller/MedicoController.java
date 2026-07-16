package com.ms_medicos.ms_medicos.controller;

import com.ms_medicos.ms_medicos.model.Medico;
import com.ms_medicos.ms_medicos.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping
    public ResponseEntity<List<Medico>> listar() {
        return ResponseEntity.ok(medicoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscar(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(medicoService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Medico> guardar(@RequestBody Medico medico) {
        return ResponseEntity.ok(medicoService.save(medico));
    }
}