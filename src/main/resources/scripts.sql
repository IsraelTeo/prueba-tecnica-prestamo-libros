-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS prestamos_libros_db;

-- Usar la base de datos
USE prestamos_libros_db;

-- Crear la tabla users
CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(80) NOT NULL,
    dni VARCHAR(12) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);