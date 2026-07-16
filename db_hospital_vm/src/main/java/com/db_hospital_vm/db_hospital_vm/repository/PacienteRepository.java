package com.db_hospital_vm.db_hospital_vm.repository;

import com.db_hospital_vm.db_hospital_vm.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {

}