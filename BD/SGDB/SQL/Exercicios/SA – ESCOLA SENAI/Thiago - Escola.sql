-- CONSTRUÇÃO DO BANCO E TABELAS
CREATE DATABASE sa_escola;
USE sa_escola;

DESCRIBE aluno;
SELECT * from aluno;
ALTER TABLE aluno CHANGE COLUMN Nome nome VARCHAR(120);
ALTER TABLE aluno CHANGE COLUMN `Data de Nascimento` dt_nasc DATE;
ALTER TABLE aluno CHANGE COLUMN CPF cpf char(11);
ALTER TABLE aluno CHANGE COLUMN Sexo sexo Enum("M", "F");
ALTER TABLE aluno CHANGE COLUMN RA ra INT PRIMARY KEY;

DESCRIBE campus;
SELECT * FROM campus;
ALTER TABLE campus CHANGE COLUMN `Código do Campus` cod INT PRIMARY KEY;
ALTER TABLE campus CHANGE COLUMN Cidade cidade VARCHAR(32);
ALTER TABLE campus CHANGE COLUMN Endereço endereco VARCHAR(120);

DESCRIBE curso;
SELECT * FROM curso;
ALTER TABLE curso CHANGE COLUMN `Código de Curso` cod INT PRIMARY KEY;
ALTER TABLE curso CHANGE COLUMN `Nome do Curso` nome VARCHAR(120);
ALTER TABLE curso CHANGE COLUMN Turno turno VARCHAR(16);
ALTER TABLE curso CHANGE COLUMN `Duração (Semestres)` duracao INT;
ALTER TABLE curso CHANGE COLUMN `Valor (R$)` valor DECIMAL (7,2);
ALTER TABLE curso CHANGE COLUMN Campus cod_campus INT;
DELETE FROM curso WHERE cod = 0;
ALTER TABLE curso ADD FOREIGN KEY (cod_campus) REFERENCES campus(cod);

DESCRIBE matricula;
SELECT * FROM matricula;
ALTER TABLE matricula CHANGE COLUMN `Código de Matrícula` cod INT PRIMARY KEY;
ALTER TABLE matricula CHANGE COLUMN `Data de Matrícula` dt_matricula DATE;
ALTER TABLE matricula CHANGE COLUMN `Registro Acadêmico` ra_aluno INT;
ALTER TABLE matricula ADD FOREIGN KEY (ra_aluno) REFERENCES aluno(ra);
ALTER TABLE matricula CHANGE COLUMN `Código de Curso` cod_curso INT;
ALTER TABLE matricula ADD FOREIGN KEY (cod_curso) REFERENCES curso(cod);

-- QUERIES

-- Lista de todos os cursos do campus de Vitória
SELECT 
	* 
FROM 
	curso 
WHERE 
	cod_campus = (
		SELECT cod FROM campus WHERE cidade = "Vitória"
	);

-- Lista de todos os cursos em ordem Alfabética
SELECT nome FROM curso ORDER BY nome ASC;

-- Quais os 5 cursos mais caros?
SELECT nome, valor FROM curso ORDER BY valor DESC LIMIT 5;

-- Qual curso é o mais barato no Campus da Serra?
SELECT
	nome, valor
FROM 
	(SELECT 
		nome, valor, cod_campus
	 FROM 
		curso 
     WHERE
		cod_campus = (
			SELECT cod FROM campus WHERE cidade = "Serra")
	) AS cursos_serra
ORDER BY valor ASC LIMIT 1;

-- Qual o turno com mais cursos disponíveis?
SELECT turno, COUNT(cod) as cursos FROM curso GROUP BY turno ORDER BY cursos DESC LIMIT 1;

-- Quantos cursos duram mais de dois anos e meio?
SELECT COUNT(cod) AS cursos FROM curso WHERE duracao > 5;

-- Quais os cursos com maior quantidade de alunos inscritos?  MECHER!!
SELECT
	m.cod_curso AS cod_curso,
    c.nome AS nome_curso,
    alunos
FROM 
	(SELECT cod_curso, COUNT(ra_aluno) AS alunos FROM matricula GROUP BY cod_curso) AS m 
		INNER JOIN
			curso c
		ON c.cod = m.cod_curso;

-- Qual a média de preço dos cursos listados?
SELECT ROUND(AVG(valor), 2) AS valor_medio FROM curso;

-- Quais cursos duram mais tempo
SELECT nome, duracao FROM curso ORDER BY duracao DESC LIMIT 5;

-- Quantos alunos estão matriculados em cada turno?
SELECT
	c.turno as turno, COUNT(m.ra_aluno) AS matriculados
FROM 
	matricula m INNER JOIN curso c ON c.cod = m.cod_curso
GROUP BY turno
ORDER BY turno ASC;

-- Qual o campus com mais cursos?
SELECT 
	campus.cidade as campus,
	COUNT(curso.cod) AS cursos
FROM
	curso INNER JOIN campus ON campus.cod = curso.cod_campus
GROUP BY campus.cod
ORDER BY cursos DESC
LIMIT 1;

-- Quais cursos não possuem alunos cadastrados?
SELECT
	curso.nome AS curso
FROM
	matricula RIGHT JOIN curso
		ON curso.cod = matricula.cod_curso
WHERE
	matricula.ra_aluno IS NULL;

-- Quem se matriculou em 2021?
SELECT
	aluno.nome, matriculas_ano.ano_matricula
FROM
	(SELECT ra_aluno, YEAR(matricula.dt_matricula) AS ano_matricula FROM matricula) AS matriculas_ano
		INNER JOIN aluno ON aluno.ra = matriculas_ano.ra_aluno
WHERE ano_matricula = 2021;

-- Qual a data de matrícula da aluna “Fernanda Lima”?
SELECT
	dt_matricula
FROM
	matricula
WHERE
	ra_aluno = (
		SELECT ra FROM aluno WHERE nome LIKE("%Fernanda Lima%")
	);

-- Quais alunos não se cadastraram em nenhum curso?
SELECT
	aluno.nome
FROM
	aluno LEFT JOIN matricula
		ON matricula.ra_aluno = aluno.ra
WHERE
	matricula.cod IS NULL;

-- Quantas alunas matriculadas até o momento?
SELECT
	COUNT(DISTINCT aluno.nome) AS alunas_matriculadas
FROM
	aluno LEFT JOIN matricula
		ON matricula.ra_aluno = aluno.ra
WHERE
	aluno.sexo = "F";

-- Quais alunos estão matriculados em 3 cursos?


-- Qual o curso do aluno “Guilherme Costa”?
SELECT
curso.nome
FROM
	(SELECT
		cod_curso
	 FROM matricula
     WHERE
		ra_aluno = (SELECT ra
					FROM aluno
                    WHERE nome LIKE ("%Guilherme Costa%")
                    )
	) AS cursos_aluno INNER JOIN curso ON curso.cod = cursos_aluno.cod_curso;

-- Quais os alunos matriculados em “Ciência da computação”
SELECT
	aluno.nome
FROM
	(SELECT ra_aluno FROM matricula
		WHERE
			cod_curso = (SELECT cod FROM curso
						WHERE nome LIKE ("%Ciência da computação%")
						)
	) AS alunos_curso
	INNER JOIN aluno ON aluno.ra = alunos_curso.ra_aluno;

-- Relação completa de todos os alunos e seus cursos
SELECT
	aluno.nome AS aluno, curso.nome AS curso
FROM 
	aluno LEFT JOIN matricula 
		ON matricula.ra_aluno = aluno.ra
	LEFT JOIN curso ON matricula.cod_curso = curso.cod;