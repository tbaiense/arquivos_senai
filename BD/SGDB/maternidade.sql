CREATE DATABASE maternidade
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

DROP DATABASE maternidade;

USE maternidade;

CREATE TABLE mae(
	id_mae INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	telefone CHAR(11),
	endereco VARCHAR(100),
	dt_nasc DATE
);
DESCRIBE mae;
CREATE TABLE medico(
	id_medico INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    crm_medico VARCHAR(8),
    nome_medico VARCHAR(40),
	especialidade ENUM("Geral", "Pediatra", "Obstetra", "Cirurgião") DEFAULT "Geral"
);
DESCRIBE medico;
CREATE TABLE bebe(
	id_bebe INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50),
    sexo CHAR(1),
    peso_nasc DECIMAL(5,3),
    altura DECIMAL(4,2),
    dt_nasc DATETIME DEFAULT CURRENT_TIMESTAMP,
    mae_id INT,
    medico_id INT,
    FOREIGN KEY (mae_id) REFERENCES mae(id_mae),
    FOREIGN KEY (medico_id) REFERENCES medico(id_medico)
);

SELECT * FROM mae;
SELECT * FROM medico;
SELECT * FROM bebe;

INSERT INTO mae(nome, telefone, endereco, dt_nasc) VALUES 
	("gertrudes", "2140028922"	, "rua dos bobos"		, "1987-06-01"),
    ("maria"	, "27123456789"	, "rua felizes"			, "1947-06-01"),
    ("antonia"	, "00000000"	, "rua dos robos"		, "1987-06-01"),
    ("carla"	, "11111111"	, "rua dos mariola"		, "1947-06-01"),
    ("joana"	, "22222222"	, "rua dos anjos"		, "1987-06-01"),
    ("beatriz"	, "33333333"	, "rua dos moribundos"	, "1947-06-01")
;

SELECT * FROM mae;
-- Deletar tudo de uma tabela
DELETE FROM mae;

INSERT INTO medico(crm_medico, nome_medico, especialidade) VALUES 
	("1234"	, "JOANA"	, "Geral"),
	("2344"	, "JOAO"	, "Obstetra"),
    ("1224"	, "carlos"	, "Pediatra"),
    ("4432"	, "estácio"	, "Cirurgião"),
    ("5533"	, "ruan"	, "Geral")
;

INSERT INTO medico VALUE
	(DEFAULT, "0000", "mario elias", DEFAULT)
;

INSERT INTO bebe(nome, sexo, peso_nasc, altura, mae_id, medico_id) VALUES
	("joaozinho"	, 'M', 2.200	, 0.12	, 31, 2),
    ("mariazinho"	, 'F', 4.350	, 0.199	, 33, 4)
;

-- Adiciona usando valor padrão
INSERT INTO bebe(id_bebe, nome, sexo, peso_nasc, altura, mae_id, medico_id) VALUE
	(DEFAULT, "joaozinho", 'M', 2.200, 0.12, 31, 2)
;

UPDATE bebe
SET nome="josue"
WHERE id_bebe=4;