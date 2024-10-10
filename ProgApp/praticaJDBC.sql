CREATE DATABASE cadastro;
USE cadastro;

CREATE TABLE cliente(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(32) NOT NULL,
    sexo ENUM("M", "F") NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

DESCRIBE cliente;