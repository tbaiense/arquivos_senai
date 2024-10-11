DROP DATABASE IF EXISTS cadastro;
CREATE DATABASE cadastro;
USE cadastro;

CREATE TABLE cliente(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(32) NOT NULL,
    sexo ENUM("M", "F") NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE produto(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(24) NOT NULL
);

CREATE TABLE produto_cliente(
	id_produto INT NOT NULL,
	id_cliente INT NOT NULL,
	PRIMARY KEY (id_produto, id_cliente),
	FOREIGN KEY (id_produto) REFERENCES produto(id),
	FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);