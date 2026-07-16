package com.ms_citas.ms_citas.service;

import com.ms_citas.ms_citas.model.Cita;
import com.ms_citas.ms_citas.repository.CitaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class CitaService {

    private static final Logger log = LoggerFactory.getLogger(CitaService.class);

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> findAll() {
        log.info("Listando todas las citas");
        return citaRepository.findAll();
    }

    public Cita findById(Integer id) {
        log.info("Buscando cita con id={}", id);
        return citaRepository.findById(id).get();
    }

    public Cita save(Cita cita) {
        log.info("Guardando cita para pacienteId={}", cita.getPacienteId());
        return citaRepository.save(cita);
    }

    public void delete(Integer id) {
        log.info("Eliminando cita con id={}", id);
        citaRepository.deleteById(id);
    }
}