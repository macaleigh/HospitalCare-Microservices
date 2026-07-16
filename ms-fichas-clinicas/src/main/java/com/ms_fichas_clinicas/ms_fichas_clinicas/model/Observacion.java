package com.ms_fichas_clinicas.ms_fichas_clinicas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table(name = "observacion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Observacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El texto de la observación es obligatorio")
    @Column(nullable = false, length = 500)
    private String texto;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ficha_clinica_id", nullable = false)
    private FichaClinica fichaClinica;
}
