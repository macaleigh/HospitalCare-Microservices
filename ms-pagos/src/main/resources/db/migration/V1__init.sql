CREATE TABLE pago (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      paciente_id INT NOT NULL,
                      monto DOUBLE NOT NULL,
                      metodo_pago VARCHAR(50) NOT NULL,
                      estado VARCHAR(50) NOT NULL,
                      fecha DATE NOT NULL
);