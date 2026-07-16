package com.ms_pagos.ms_pagos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "El id de paciente es obligatorio")
    @Column(nullable = false)
    private Integer pacienteId;

    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a 0")
    @Column(nullable = false)
    private Double monto;

    @NotBlank(message = "El método de pago es obligatorio")
    @Column(nullable = false)
    private String metodoPago;

    @NotBlank(message = "El estado es obligatorio")
    @Column(nullable = false)
    private String estado;

    @NotNull(message = "La fecha es obligatoria")
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;
}