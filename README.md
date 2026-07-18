# HospitalCare Microservices

Sistema Distribuido de Gestión Hospitalaria — Proyecto EFT DSY1103 (Desarrollo Fullstack I)

## Descripción del proyecto

HospitalCare es un sistema de gestión hospitalaria basado en arquitectura de microservicios, desarrollado como continuación de las Evaluaciones Parciales 2 y 3 de la asignatura Desarrollo Fullstack I. Cada microservicio es independiente, con su propia base de datos, y se comunica con los demás a través de un API Gateway centralizado, utilizando Eureka Server para el registro y descubrimiento de servicios.

## Integrantes

- Macarena Leighton

## Microservicios implementados

| Microservicio | Puerto | Base de datos | Descripción |
|---|---|---|---|
| db-hospital-vm | 8080 | db_hospital_vm | Gestión de pacientes |
| ms-medicos | 8081 | ms_medicos | Gestión de médicos |
| ms-especialidades | 8083 | ms_especialidades | Especialidades médicas |
| ms-citas | 8084 | ms_citas | Citas médicas |
| ms-fichas-clinicas | 8085 | ms_fichas_clinicas | Fichas clínicas y observaciones (relación @OneToMany) |
| ms-recetas | 8086 | ms_recetas | Recetas médicas |
| ms-examenes | 8087 | ms_examenes | Exámenes médicos |
| ms-hospitalizacion | 8088 | ms_hospitalizacion | Hospitalizaciones |
| ms-urgencias | 8089 | ms_urgencias | Atenciones de urgencia |
| ms-pagos | 8090 | ms_pagos | Pagos y convenios |
| eureka-server | 8761 | — | Service Discovery |
| api-gateway | 9000 | — | Punto de entrada único |

## Arquitectura

- **Patrón:** Controller – Service – Repository (CSR)
- **Persistencia:** Spring Data JPA + MySQL, con migraciones versionadas mediante Flyway
- **Validaciones:** Bean Validation (JSR 380)
- **Manejo de errores:** `@RestControllerAdvice` centralizado en cada microservicio
- **Logs:** SLF4J con trazabilidad de eventos (creación, búsqueda, eliminación)
- **Comunicación entre microservicios:** WebClient (ej. `db-hospital-vm` consulta a `ms-medicos`)
- **Relación JPA real:** `FichaClinica` (1) → `Observacion` (N) mediante `@OneToMany`/`@ManyToOne`
- **Documentación:** Swagger/OpenAPI (springdoc) en cada microservicio
- **Registro de servicios:** Eureka Server
- **Enrutamiento centralizado:** Spring Cloud Gateway (Server WebMVC)

## Rutas principales del API Gateway

Todas las peticiones pasan por `http://localhost:9000`

| Ruta | Microservicio destino |
|---|---|
| `/api/v1/pacientes/**` | db-hospital-vm |
| `/api/v1/medicos/**` | ms-medicos |
| `/api/v1/especialidades/**` | ms-especialidades |
| `/api/v1/citas/**` | ms-citas |
| `/api/v1/fichas-clinicas/**` | ms-fichas-clinicas |
| `/api/v1/recetas/**` | ms-recetas |
| `/api/v1/examenes/**` | ms-examenes |
| `/api/v1/hospitalizaciones/**` | ms-hospitalizacion |
| `/api/v1/urgencias/**` | ms-urgencias |
| `/api/v1/pagos/**` | ms-pagos |

## Documentación Swagger (local)

- Pacientes: http://localhost:8080/swagger-ui.html
- Médicos: http://localhost:8081/swagger-ui.html
- Especialidades: http://localhost:8083/swagger-ui.html
- Citas: http://localhost:8084/swagger-ui.html
- Fichas Clínicas: http://localhost:8085/swagger-ui.html
- Recetas: http://localhost:8086/swagger-ui.html
- Exámenes: http://localhost:8087/swagger-ui.html
- Hospitalización: http://localhost:8088/swagger-ui.html
- Urgencias: http://localhost:8089/swagger-ui.html
- Pagos: http://localhost:8090/swagger-ui.html

## Pruebas unitarias

Se implementaron pruebas unitarias con JUnit 5 + Mockito (patrón Given-When-Then) en:
- `PacienteServiceTest` (db-hospital-vm)
- `MedicoServiceTest` (ms-medicos)
- `EspecialidadServiceTest` (ms-especialidades)

Cada test utiliza `@Mock` para simular el repositorio y `@InjectMocks` para inyectar el service, validando los métodos `findAll`, `findById` (caso exitoso y excepción `NoSuchElementException`), `save` y `delete`.

## Instrucciones de ejecución local

### Requisitos previos
- Java 21
- MySQL (via Laragon u otro gestor)
- Maven

### Pasos

1. Crear las bases de datos necesarias en MySQL:

```sql
CREATE DATABASE IF NOT EXISTS db_hospital_vm;
CREATE DATABASE IF NOT EXISTS ms_medicos;
CREATE DATABASE IF NOT EXISTS ms_especialidades;
CREATE DATABASE IF NOT EXISTS ms_citas;
CREATE DATABASE IF NOT EXISTS ms_fichas_clinicas;
CREATE DATABASE IF NOT EXISTS ms_recetas;
CREATE DATABASE IF NOT EXISTS ms_examenes;
CREATE DATABASE IF NOT EXISTS ms_hospitalizacion;
CREATE DATABASE IF NOT EXISTS ms_urgencias;
CREATE DATABASE IF NOT EXISTS ms_pagos;
```

2. Levantar los servicios en este orden:
    1. `eureka-server` (esperar que cargue el dashboard en `http://localhost:8761`)
    2. Los 10 microservicios (en cualquier orden)
    3. `api-gateway`

3. Verificar que todos los servicios aparezcan registrados en `http://localhost:8761`

4. Probar el sistema a través del Gateway, por ejemplo:

GET http://localhost:9000/api/v1/pacientes