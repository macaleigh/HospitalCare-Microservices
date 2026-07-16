CREATE TABLE medico (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL,
                        especialidad VARCHAR(100) NOT NULL,
                        correo VARCHAR(100) NOT NULL UNIQUE
);