package com.ms_fichas_clinicas.ms_fichas_clinicas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ficha_clinica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FichaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El id de paciente es obligatorio")
    @Column(nullable = false)
    private Integer pacienteId;

    @NotBlank(message = "El diagnóstico es obligatorio")
    @Column(nullable = false)
    private String diagnostico;

    @Column(nullable = true)
    private String observaciones;

    @NotNull(message = "La fecha de creación es obligatoria")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaCreacion;

    @OneToMany(mappedBy = "fichaClinica", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Observacion> listaObservaciones;
}