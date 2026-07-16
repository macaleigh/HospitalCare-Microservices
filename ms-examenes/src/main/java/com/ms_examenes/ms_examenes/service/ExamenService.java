package com.ms_examenes.ms_examenes.service;

import com.ms_examenes.ms_examenes.model.Examen;
import com.ms_examenes.ms_examenes.repository.ExamenRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class ExamenService {

    private static final Logger log = LoggerFactory.getLogger(ExamenService.class);

    @Autowired
    private ExamenRepository examenRepository;

    public List<Examen> findAll() {
        log.info("Listando todos los exámenes");
        return examenRepository.findAll();
    }

    public Examen findById(Integer id) {
        log.info("Buscando examen con id={}", id);
        return examenRepository.findById(id).get();
    }

    public Examen save(Examen examen) {
        log.info("Guardando examen para pacienteId={}", examen.getPacienteId());
        return examenRepository.save(examen);
    }

    public void delete(Integer id) {
        log.info("Eliminando examen con id={}", id);
        examenRepository.deleteById(id);
    }
}