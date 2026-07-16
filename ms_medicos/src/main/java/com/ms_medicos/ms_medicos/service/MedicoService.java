package com.ms_medicos.ms_medicos.service;

import com.ms_medicos.ms_medicos.model.Medico;
import com.ms_medicos.ms_medicos.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll() {
        return medicoRepository.findAll();
    }

    public Medico findById(Integer id) {
        return medicoRepository.findById(id).get();
    }

    public Medico save(Medico medico) {
        return medicoRepository.save(medico);
    }
}