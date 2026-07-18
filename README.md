# HospitalCare Microservices

Sistema Distribuido de Gestion Hospitalaria - Proyecto EFT DSY1103 (Desarrollo Fullstack I)

## Descripcion del proyecto

HospitalCare es un sistema de gestion hospitalaria basado en arquitectura de microservicios, desarrollado como continuacion de las Evaluaciones Parciales 2 y 3 de la asignatura Desarrollo Fullstack I. Cada microservicio es independiente, con su propia base de datos, y se comunica con los demas a traves de un API Gateway centralizado, utilizando Eureka Server para el registro y descubrimiento de servicios.

## Integrantes

- Macarena Leighton

## Microservicios implementados

| Microservicio | Puerto | Base de datos | Descripcion |
|---|---|---|---|
| db-hospital-vm | 8080 | db_hospital_vm | Gestion de pacientes |
| ms-medicos | 8081 | ms_medicos | Gestion de medicos |
| ms-especialidades | 8083 | ms_especialidades | Especialidades medicas |
| ms-citas | 8084 | ms_citas | Citas medicas |
| ms-fichas-clinicas | 8085 | ms_fichas_clinicas | Fichas clinicas y observaciones (relacion OneToMany) |
| ms-recetas | 8086 | ms_recetas | Recetas medicas |
| ms-examenes | 8087 | ms_examenes | Examenes medicos |
| ms-hospitalizacion | 8088 | ms_hospitalizacion | Hospitalizaciones |
| ms-urgencias | 8089 | ms_urgencias | Atenciones de urgencia |
| ms-pagos | 8090 | ms_pagos | Pagos y convenios |
| eureka-server | 8761 | - | Service Discovery |
| api-gateway | 9000 | - | Punto de entrada unico |

## Arquitectura

- Patron: Controller - Service - Repository (CSR)
- Persistencia: Spring Data JPA + MySQL, con migraciones versionadas mediante Flyway
- Validaciones: Bean Validation (JSR 380)
- Manejo de errores: RestControllerAdvice centralizado en cada microservicio
- Logs: SLF4J con trazabilidad de eventos
- Comunicacion entre microservicios: WebClient
- Relacion JPA real: FichaClinica (1) a Observacion (N) mediante OneToMany/ManyToOne
- Documentacion: Swagger/OpenAPI (springdoc) en cada microservicio
- Registro de servicios: Eureka Server
- Enrutamiento centralizado: Spring Cloud Gateway (Server WebMVC)

## Rutas principales del API Gateway

Todas las peticiones pasan por http://localhost:9000

| Ruta | Microservicio destino |
|---|---|
| /api/v1/pacientes/** | db-hospital-vm |
| /api/v1/medicos/** | ms-medicos |
| /api/v1/especialidades/** | ms-especialidades |
| /api/v1/citas/** | ms-citas |
| /api/v1/fichas-clinicas/** | ms-fichas-clinicas |
| /api/v1/recetas/** | ms-recetas |
| /api/v1/examenes/** | ms-examenes |
| /api/v1/hospitalizaciones/** | ms-hospitalizacion |
| /api/v1/urgencias/** | ms-urgencias |
| /api/v1/pagos/** | ms-pagos |

## Pruebas unitarias

Se implementaron pruebas unitarias con JUnit 5 + Mockito en:
- PacienteServiceTest (db-hospital-vm)
- MedicoServiceTest (ms-medicos)
- EspecialidadServiceTest (ms-especialidades)

## Tecnologias utilizadas

- Spring Boot 4.1.0
- Spring Cloud 2025.1.2 (Eureka, Gateway Server WebMVC)
- Spring Data JPA + Hibernate
- MySQL 8.4
- Flyway
- springdoc-openapi 3.0.3 (Swagger)
- JUnit 5 + Mockito
- Lombok
- Maven
