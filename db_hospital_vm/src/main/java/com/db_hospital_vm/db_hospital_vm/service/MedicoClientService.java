package com.db_hospital_vm.db_hospital_vm.service;

import com.db_hospital_vm.db_hospital_vm.dto.MedicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MedicoClientService {

    @Autowired
    private WebClient webClient;
    public MedicoDTO obtenerMedico(Integer id) {
        return webClient.get()
                .uri("http://localhost:8081/api/v1/medicos/" + id)
                .retrieve()
                .bodyToMono(MedicoDTO.class)
                .block();
    }
}