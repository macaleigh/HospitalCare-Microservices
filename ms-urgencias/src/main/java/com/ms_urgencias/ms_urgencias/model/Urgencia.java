package com.ms_urgencias.ms_urgencias.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "urgencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Urgencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El id de paciente es obligatorio")
    @Column(nullable = false)
    private Integer pacienteId;

    @NotBlank(message = "La prioridad es obligatoria")
    @Column(nullable = false)
    private String prioridad;

    @NotBlank(message = "Los síntomas son obligatorios")
    @Column(nullable = false)
    private String sintomas;

    @NotNull(message = "La fecha de atención es obligatoria")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date fechaAtencion;
}