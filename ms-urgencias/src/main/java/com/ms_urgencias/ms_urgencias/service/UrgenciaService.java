package com.ms_urgencias.ms_urgencias.service;

import com.ms_urgencias.ms_urgencias.model.Urgencia;
import com.ms_urgencias.ms_urgencias.repository.UrgenciaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class UrgenciaService {

    private static final Logger log = LoggerFactory.getLogger(UrgenciaService.class);

    @Autowired
    private UrgenciaRepository urgenciaRepository;

    public List<Urgencia> findAll() {
        log.info("Listando todas las urgencias");
        return urgenciaRepository.findAll();
    }

    public Urgencia findById(Integer id) {
        log.info("Buscando urgencia con id={}", id);
        return urgenciaRepository.findById(id).get();
    }

    public Urgencia save(Urgencia urgencia) {
        log.info("Guardando urgencia para pacienteId={}", urgencia.getPacienteId());
        return urgenciaRepository.save(urgencia);
    }

    public void delete(Integer id) {
        log.info("Eliminando urgencia con id={}", id);
        urgenciaRepository.deleteById(id);
    }
}