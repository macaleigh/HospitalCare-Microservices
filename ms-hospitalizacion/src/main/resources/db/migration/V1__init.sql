CREATE TABLE hospitalizacion (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 paciente_id INT NOT NULL,
                                 habitacion VARCHAR(50) NOT NULL,
                                 fecha_ingreso DATE NOT NULL,
                                 fecha_alta DATE,
                                 motivo VARCHAR(255) NOT NULL
);