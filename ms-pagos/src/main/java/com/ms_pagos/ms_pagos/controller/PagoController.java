package com.ms_pagos.ms_pagos.controller;

import com.ms_pagos.ms_pagos.model.Pago;
import com.ms_pagos.ms_pagos.service.PagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public ResponseEntity<List<Pago>> listar() {
        List<Pago> pagos = pagoService.findAll();
        if (pagos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(pagos);
    }

    @PostMapping
    public ResponseEntity<Pago> guardar(@Valid @RequestBody Pago pago) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.save(pago));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(pagoService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizar(@PathVariable Integer id, @Valid @RequestBody Pago pago) {
        Pago p = pagoService.findById(id);
        p.setPacienteId(pago.getPacienteId());
        p.setMonto(pago.getMonto());
        p.setMetodoPago(pago.getMetodoPago());
        p.setEstado(pago.getEstado());
        p.setFecha(pago.getFecha());
        pagoService.save(p);
        return ResponseEntity.ok(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        pagoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}