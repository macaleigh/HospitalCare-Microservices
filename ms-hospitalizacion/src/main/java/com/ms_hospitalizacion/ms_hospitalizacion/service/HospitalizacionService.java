package com.ms_hospitalizacion.ms_hospitalizacion.service;

import com.ms_hospitalizacion.ms_hospitalizacion.model.Hospitalizacion;
import com.ms_hospitalizacion.ms_hospitalizacion.repository.HospitalizacionRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class HospitalizacionService {

    private static final Logger log = LoggerFactory.getLogger(HospitalizacionService.class);

    @Autowired
    private HospitalizacionRepository hospitalizacionRepository;

    public List<Hospitalizacion> findAll() {
        log.info("Listando todas las hospitalizaciones");
        return hospitalizacionRepository.findAll();
    }

    public Hospitalizacion findById(Integer id) {
        log.info("Buscando hospitalización con id={}", id);
        return hospitalizacionRepository.findById(id).get();
    }

    public Hospitalizacion save(Hospitalizacion hospitalizacion) {
        log.info("Guardando hospitalización para pacienteId={}", hospitalizacion.getPacienteId());
        return hospitalizacionRepository.save(hospitalizacion);
    }

    public void delete(Integer id) {
        log.info("Eliminando hospitalización con id={}", id);
        hospitalizacionRepository.deleteById(id);
    }
}