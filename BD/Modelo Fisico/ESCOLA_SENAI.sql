DROP DATABASE IF EXISTS ESCOLA_SENAI;
CREATE DATABASE ESCOLA_SENAI
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;
USE ESCOLA_SENAI;
CREATE TABLE TB_ALUNO(
	RA_ALUN INT NOT NULL AUTO_INCREMENT,
    NOME_ALU VARCHAR(40),
    DT_NASC_ALU DATE,
    CPF_ALU CHAR(11),
    SEXO_ALU CHAR(1),
    PRIMARY KEY (RA_ALUN)
);
CREATE TABLE TB_CURSO (
	COD_CURS INT NOT NULL AUTO_INCREMENT,
    NOME_CURS VARCHAR(100) NOT NULL,
    PER_CURS ENUM("Verspertino", "Matutino", "Noturno", "Integral", "Verspertino-Noturno", "N/A") DEFAULT "N/A",
    DUR_CURS INT NOT NULL,
    VALOR_CURS DECIMAL(7,2) NOT NULL,
    PRIMARY KEY (COD_CURS)
);
CREATE TABLE TB_MATRICULA (
	COD_MAT INT NOT NULL AUTO_INCREMENT,
    RA_ALU INT NOT NULL,
    DATA_MAT DATE,
    COD_CURS INT NOT NULL,
    PRIMARY KEY (COD_MAT),
    CONSTRAINT fk_TB_MATRICULA_RA_ALU FOREIGN KEY (RA_ALU) REFERENCES TB_ALUNO(RA_ALUN),
    CONSTRAINT fk_TB_MATRICULA_COD_CURS FOREIGN KEY (COD_CURS) REFERENCES TB_CURSO(COD_CURS)
);

INSERT INTO TB_ALUNO VALUES 
	(DEFAULT, "Joao da Silva"			, "2001-12-30"	, "12345678910"	, "M"),
    (DEFAULT, "Maria Antonia"			, "2003-04-02"	, "12345678900"	, "F"),
    (DEFAULT, "Reginaldo Marques"		, "2001-12-09"	, "45672244890"	, "M"),
    (DEFAULT, "Natália Soares"			, "2007-12-03"	, "21523452345"	, "F"),
    (DEFAULT, "Mauro Pinheiros"			, "2001-04-09"	, "123412'2112"	, "M"),
    (DEFAULT, "Carlos Eduardo"			, "2000-12-17"	, "33344212313"	, "M"),
    (DEFAULT, "Pedro Henrique Oliveria"	, "2007-12-02"	, "42342345566"	, "M"),
    (DEFAULT, "Rodrigo Oliz"			, "2008-12-30"	, "98765234556"	, "M"),
    (DEFAULT, "Rita Kowasky"			, "2001-04-22"	, "32189345234"	, "F"),
    (DEFAULT, "Raphael Kobayashi"		, "2003-12-02"	, "23425553433"	, "M")
;

INSERT INTO TB_CURSO VALUES 
    (DEFAULT, "Desenvolvimento de Sistemas"	, "Noturno"		, 1280	, 5250.99),
    (DEFAULT, "Cibersegurança"				, "Matutino"	, 140	, 450.99),
    (DEFAULT, "Eletrotécnica"				, "Integral"	, 1280	, 7250.99),
    (DEFAULT, "Automação"					, "Verspertino"	, 320	, 900.99),
    (DEFAULT, "Segurança do Trabalho"		, "Matutino"	, 1280	, 4250.99)
;

INSERT INTO TB_MATRICULA VALUES 
	(DEFAULT, 1	, "2022-01-20", 1),
    (DEFAULT, 1	, "2022-02-20", 1),
    (DEFAULT, 1	, "2022-04-20", 2),
    (DEFAULT, 1	, "2022-04-20", 3),
    (DEFAULT, 2	, "2022-09-20", 1),
    (DEFAULT, 2	, "2022-09-20", 2),
    (DEFAULT, 2	, "2022-09-20", 4),
    (DEFAULT, 3	, "2023-01-20", 1),
    (DEFAULT, 4	, "2023-02-20", 1),
    (DEFAULT, 4	, "2023-02-20", 2),
    (DEFAULT, 5	, "2023-04-20", 1),
    (DEFAULT, 5	, "2023-04-20", 2),
    (DEFAULT, 5	, "2023-09-20", 3),
    (DEFAULT, 5	, "2024-01-20", 4),
    (DEFAULT, 5	, "2024-02-20", 1),
    (DEFAULT, 8	, "2024-02-20", 2),
    (DEFAULT, 9	, "2024-04-20", 1),
    (DEFAULT, 6	, "2024-04-20", 4),
    (DEFAULT, 7	, "2024-09-20", 1),
    (DEFAULT, 7	, "2024-09-20", 2)
;