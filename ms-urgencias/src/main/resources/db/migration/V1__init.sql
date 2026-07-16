CREATE TABLE urgencia (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          paciente_id INT NOT NULL,
                          prioridad VARCHAR(50) NOT NULL,
                          sintomas VARCHAR(255) NOT NULL,
                          fecha_atencion DATETIME NOT NULL
);