CREATE DATABASE papelaria;
USE papelaria;

CREATE TABLE caderno(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    modelo VARCHAR(32) NOT NULL,
    paginas INT NOT NULL,
    ativo BIT(1) NOT NULL DEFAULT b'1',
    gramatura ENUM("70g", "100g") NOT NULL
);

SELECT * FROM caderno;
INSERT INTO caderno(modelo, paginas, ativo, gramatura) VALUE ("SONIX", 100, b'1', "70g");