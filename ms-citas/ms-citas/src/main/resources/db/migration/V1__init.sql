CREATE TABLE cita (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      paciente_id INT NOT NULL,
                      medico_id INT NOT NULL,
                      especialidad_id INT NOT NULL,
                      fecha DATE NOT NULL,
                      hora VARCHAR(10) NOT NULL,
                      estado VARCHAR(50) NOT NULL
);