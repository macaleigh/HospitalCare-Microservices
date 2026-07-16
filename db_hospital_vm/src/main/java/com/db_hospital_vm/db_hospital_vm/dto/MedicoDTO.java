package com.db_hospital_vm.db_hospital_vm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoDTO {
    private Integer id;
    private String nombre;
    private String especialidad;
    private String correo;
}