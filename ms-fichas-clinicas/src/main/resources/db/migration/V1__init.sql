CREATE TABLE ficha_clinica (
                               id INT AUTO_INCREMENT PRIMARY KEY,
                               paciente_id INT NOT NULL,
                               diagnostico VARCHAR(255) NOT NULL,
                               observaciones VARCHAR(500),
                               fecha_creacion DATE NOT NULL
);