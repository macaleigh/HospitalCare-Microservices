CREATE TABLE examen (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        paciente_id INT NOT NULL,
                        tipo_examen VARCHAR(100) NOT NULL,
                        resultado VARCHAR(255),
                        fecha_examen DATE NOT NULL
);