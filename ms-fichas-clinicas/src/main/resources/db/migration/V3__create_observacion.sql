CREATE TABLE observacion (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             texto VARCHAR(500) NOT NULL,
                             fecha DATE NOT NULL,
                             ficha_clinica_id INT NOT NULL,
                             CONSTRAINT fk_observacion_ficha FOREIGN KEY (ficha_clinica_id) REFERENCES ficha_clinica(id)
);