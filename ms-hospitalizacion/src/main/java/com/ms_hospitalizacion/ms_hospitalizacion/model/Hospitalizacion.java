package com.ms_hospitalizacion.ms_hospitalizacion.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "hospitalizacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospitalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El id de paciente es obligatorio")
    @Column(nullable = false)
    private Integer pacienteId;

    @NotBlank(message = "La habitación es obligatoria")
    @Column(nullable = false)
    private String habitacion;

    @NotNull(message = "La fecha de ingreso es obligatoria")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaIngreso;

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date fechaAlta;

    @NotBlank(message = "El motivo es obligatorio")
    @Column(nullable = false)
    private String motivo;
}