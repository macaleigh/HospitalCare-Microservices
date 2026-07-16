package com.ms_especialidades.ms_especialidades.repository;

import com.ms_especialidades.ms_especialidades.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {
}