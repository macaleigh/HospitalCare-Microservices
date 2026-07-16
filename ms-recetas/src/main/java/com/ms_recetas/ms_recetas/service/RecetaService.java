package com.ms_recetas.ms_recetas.service;

import com.ms_recetas.ms_recetas.model.Receta;
import com.ms_recetas.ms_recetas.repository.RecetaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class RecetaService {

    private static final Logger log = LoggerFactory.getLogger(RecetaService.class);

    @Autowired
    private RecetaRepository recetaRepository;

    public List<Receta> findAll() {
        log.info("Listando todas las recetas");
        return recetaRepository.findAll();
    }

    public Receta findById(Integer id) {
        log.info("Buscando receta con id={}", id);
        return recetaRepository.findById(id).get();
    }

    public Receta save(Receta receta) {
        log.info("Guardando receta para pacienteId={}", receta.getPacienteId());
        return recetaRepository.save(receta);
    }

    public void delete(Integer id) {
        log.info("Eliminando receta con id={}", id);
        recetaRepository.deleteById(id);
    }
}