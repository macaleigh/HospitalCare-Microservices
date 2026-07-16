package com.ms_citas.ms_citas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "cita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El id de paciente es obligatorio")
    @Column(nullable = false)
    private Integer pacienteId;

    @NotNull(message = "El id de médico es obligatorio")
    @Column(nullable = false)
    private Integer medicoId;

    @NotNull(message = "El id de especialidad es obligatorio")
    @Column(nullable = false)
    private Integer especialidadId;

    @NotNull(message = "La fecha es obligatoria")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

    @NotBlank(message = "La hora es obligatoria")
    @Column(nullable = false)
    private String hora;

    @NotBlank(message = "El estado es obligatorio")
    @Column(nullable = false)
    private String estado;
}