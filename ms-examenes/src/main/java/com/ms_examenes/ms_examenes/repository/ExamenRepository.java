package com.ms_examenes.ms_examenes.repository;

import com.ms_examenes.ms_examenes.model.Examen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamenRepository extends JpaRepository<Examen, Integer> {
}