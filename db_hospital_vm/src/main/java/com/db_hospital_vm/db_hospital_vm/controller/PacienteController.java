package com.db_hospital_vm.db_hospital_vm.controller;

import com.db_hospital_vm.db_hospital_vm.dto.MedicoDTO;
import com.db_hospital_vm.db_hospital_vm.model.Paciente;
import com.db_hospital_vm.db_hospital_vm.service.MedicoClientService;
import com.db_hospital_vm.db_hospital_vm.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private MedicoClientService medicoClientService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {
        List<Paciente> pacientes = pacienteService.findAll();
        if (pacientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping
    public ResponseEntity<Paciente> guardar(@Valid @RequestBody Paciente paciente) {
        Paciente productoNuevo = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoNuevo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id) {
        Paciente paciente = pacienteService.findById(id);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Integer id, @Valid @RequestBody Paciente paciente) {
        Paciente pac = pacienteService.findById(id);
        pac.setId(id);
        pac.setRun(paciente.getRun());
        pac.setNombre(paciente.getNombre());
        pac.setApellido(paciente.getApellido());
        pac.setFechaNacimiento(paciente.getFechaNacimiento());
        pac.setCorreo(paciente.getCorreo());

        pacienteService.save(pac);
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Integer id) {
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/medico/{medicoId}")
    public ResponseEntity<?> pacienteConMedico(@PathVariable Integer id, @PathVariable Integer medicoId) {
        Paciente paciente = pacienteService.findById(id);
        MedicoDTO medico = medicoClientService.obtenerMedico(medicoId);

        return ResponseEntity.ok(Map.of(
                "paciente", paciente,
                "medico", medico
        ));
    }
}