CREATE TABLE especialidad (
                              id INT AUTO_INCREMENT PRIMARY KEY,
                              nombre VARCHAR(100) NOT NULL UNIQUE,
                              descripcion VARCHAR(255) NOT NULL
);