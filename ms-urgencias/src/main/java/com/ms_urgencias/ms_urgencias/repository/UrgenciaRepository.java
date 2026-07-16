package com.ms_urgencias.ms_urgencias.repository;

import com.ms_urgencias.ms_urgencias.model.Urgencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrgenciaRepository extends JpaRepository<Urgencia, Integer> {
}
