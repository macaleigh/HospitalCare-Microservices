package com.ms_examenes.ms_examenes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "examen")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El id de paciente es obligatorio")
    @Column(nullable = false)
    private Integer pacienteId;

    @NotBlank(message = "El tipo de examen es obligatorio")
    @Column(nullable = false)
    private String tipoExamen;

    @Column(nullable = true)
    private String resultado;

    @NotNull(message = "La fecha de examen es obligatoria")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaExamen;
}