package com.ms_especialidades.ms_especialidades.service;

import com.ms_especialidades.ms_especialidades.model.Especialidad;
import com.ms_especialidades.ms_especialidades.repository.EspecialidadRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EspecialidadService {

    private static final Logger log = LoggerFactory.getLogger(EspecialidadService.class);

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> findAll() {
        log.info("Listando todas las especialidades");
        return especialidadRepository.findAll();
    }

    public Especialidad findById(Integer id) {
        log.info("Buscando especialidad con id={}", id);
        return especialidadRepository.findById(id).get();
    }

    public Especialidad save(Especialidad especialidad) {
        log.info("Guardando especialidad nombre={}", especialidad.getNombre());
        return especialidadRepository.save(especialidad);
    }

    public void delete(Integer id) {
        log.info("Eliminando especialidad con id={}", id);
        especialidadRepository.deleteById(id);
    }
}