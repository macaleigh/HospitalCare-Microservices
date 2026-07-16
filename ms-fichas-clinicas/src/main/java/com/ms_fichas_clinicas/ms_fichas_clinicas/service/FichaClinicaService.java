package com.ms_fichas_clinicas.ms_fichas_clinicas.service;

import com.ms_fichas_clinicas.ms_fichas_clinicas.model.FichaClinica;
import com.ms_fichas_clinicas.ms_fichas_clinicas.repository.FichaClinicaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class FichaClinicaService {

    private static final Logger log = LoggerFactory.getLogger(FichaClinicaService.class);

    @Autowired
    private FichaClinicaRepository fichaClinicaRepository;

    public List<FichaClinica> findAll() {
        log.info("Listando todas las fichas clínicas");
        return fichaClinicaRepository.findAll();
    }

    public FichaClinica findById(Integer id) {
        log.info("Buscando ficha clínica con id={}", id);
        return fichaClinicaRepository.findById(id).get();
    }

    public FichaClinica save(FichaClinica ficha) {
        log.info("Guardando ficha clínica para pacienteId={}", ficha.getPacienteId());
        return fichaClinicaRepository.save(ficha);
    }

    public void delete(Integer id) {
        log.info("Eliminando ficha clínica con id={}", id);
        fichaClinicaRepository.deleteById(id);
    }
}