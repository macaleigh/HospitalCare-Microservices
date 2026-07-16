package com.ms_fichas_clinicas.ms_fichas_clinicas.repository;

import com.ms_fichas_clinicas.ms_fichas_clinicas.model.Observacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ObservacionRepository extends JpaRepository<Observacion, Integer> {
}
