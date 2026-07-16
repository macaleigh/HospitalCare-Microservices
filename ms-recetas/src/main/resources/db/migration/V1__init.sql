CREATE TABLE receta (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        paciente_id INT NOT NULL,
                        medico_id INT NOT NULL,
                        medicamento VARCHAR(150) NOT NULL,
                        dosis VARCHAR(100) NOT NULL,
                        fecha_emision DATE NOT NULL
);