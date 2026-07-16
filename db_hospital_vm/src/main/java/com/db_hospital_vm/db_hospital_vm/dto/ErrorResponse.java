package com.db_hospital_vm.db_hospital_vm.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String mensaje;
    private String detalle;
    private int status;
    private LocalDateTime timestamp;
}