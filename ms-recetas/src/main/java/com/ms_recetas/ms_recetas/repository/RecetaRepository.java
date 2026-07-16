package com.ms_recetas.ms_recetas.repository;

import com.ms_recetas.ms_recetas.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Integer> {
}