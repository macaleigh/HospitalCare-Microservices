package com.db_hospital_vm.db_hospital_vm.service;

import com.db_hospital_vm.db_hospital_vm.model.Paciente;
import com.db_hospital_vm.db_hospital_vm.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PacienteService {

    private static final Logger log = LoggerFactory.getLogger(PacienteService.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> findAll() {
        log.info("Listando todos los pacientes");
        return pacienteRepository.findAll();
    }

    public Paciente findById(Integer id) {
        log.info("Buscando paciente con id={}", id);
        return pacienteRepository.findById(id).get();
    }

    public Paciente save(Paciente paciente) {
        log.info("Guardando paciente run={}", paciente.getRun());
        return pacienteRepository.save(paciente);
    }

    public void delete(Integer id) {
        log.info("Eliminando paciente con id={}", id);
        pacienteRepository.deleteById(id);
    }
}