package com.ms_recetas.ms_recetas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "receta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El id de paciente es obligatorio")
    @Column(nullable = false)
    private Integer pacienteId;

    @NotNull(message = "El id de médico es obligatorio")
    @Column(nullable = false)
    private Integer medicoId;

    @NotBlank(message = "El medicamento es obligatorio")
    @Column(nullable = false)
    private String medicamento;

    @NotBlank(message = "La dosis es obligatoria")
    @Column(nullable = false)
    private String dosis;

    @NotNull(message = "La fecha de emisión es obligatoria")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaEmision;
}