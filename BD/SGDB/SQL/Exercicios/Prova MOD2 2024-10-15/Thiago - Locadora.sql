-- CRIAÇÃO ############################################

CREATE DATABASE locadora;
USE locadora;

CREATE TABLE cliente(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(64) NOT NULL,
    email VARCHAR(64),
    dt_nascimento DATE,
    cpf VARCHAR(16),
    sexo ENUM("M", "F")
);

CREATE TABLE filme(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    id_diretor INT NOT NULL,
    FOREIGN KEY (id_diretor) REFERENCES diretor(id),
    genero VARCHAR(32),
    ano_lancamento INT,
    classificacao_ind INT
);

CREATE TABLE diretor(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome_diretor VARCHAR(64) NOT NULL
);

CREATE TABLE locacao(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    id_filme INT NOT NULL,
    FOREIGN KEY (id_filme) REFERENCES filme(id),
    dt_emprestimo DATE NOT NULL,
    dt_devolver DATE NOT NULL,
    dt_devolvido DATE
);

-- BUSCAS #############################################
-- 1 Lista de todos os filmes do Steven Spielberg
SELECT titulo FROM filme WHERE id_diretor = (SELECT id FROM diretor WHERE nome_diretor = "Steven Spielberg");

-- 2 Lista de todos os filmes por ordem de lançamento
SELECT titulo, ano_lancamento FROM filme ORDER BY ano_lancamento DESC;

-- 3 Lista de todos os filmes por do gênero Drama e Romance
SELECT titulo, genero FROM filme WHERE genero IN ("Drama", "Romance");

-- 4 Lista de todos os filmes de terror com classificação de -18 anos
SELECT titulo, classificacao_ind FROM filme WHERE genero = "Terror" AND classificacao_ind < 18;

-- 5 Qual o nome filme mais locado?
SELECT filme.titulo, locacoes
FROM 
	(SELECT id_filme, count(id) AS locacoes FROM locacao GROUP BY id_filme) AS mais_locados
		INNER JOIN filme ON filme.id = mais_locados.id_filme
WHERE 
	locacoes = (SELECT MAX(locacoes) 
				FROM (SELECT count(id) AS locacoes 
					  FROM locacao GROUP BY id_filme) AS maximo);

-- 6 Qual o cliente com mais locações?
SELECT cliente.nome, locacoes 
FROM 
	(SELECT id_cliente, count(id) as locacoes FROM locacao GROUP BY id_cliente) AS mais_locacoes
		INNER JOIN cliente ON cliente.id = mais_locacoes.id_cliente
WHERE locacoes = (SELECT MAX(locacoes) FROM (SELECT count(id) as locacoes FROM locacao GROUP BY id_cliente) AS locacoes_cliente);

-- 7 Qual o filme mais locado entre as mulheres?
SELECT filme.titulo, locacoes
FROM 
	(SELECT locacao.id_filme, count(locacao.id) AS locacoes
     FROM 
		locacao INNER JOIN cliente ON cliente.id = locacao.id_cliente 
	 WHERE cliente.sexo = "F" GROUP BY id_filme) AS mais_locados
	INNER JOIN filme ON filme.id = mais_locados.id_filme
WHERE 
	locacoes = (SELECT MAX(locacoes) 
				FROM (SELECT count(locacao.id) AS locacoes 
					  FROM locacao INNER JOIN cliente ON cliente.id = locacao.id_cliente 
                      WHERE cliente.sexo = "F" GROUP BY id_filme) 
			    AS maximo);

-- 8 Qual o filme mais locado entre os homens e do gênero ação?
SELECT *
FROM 
	(SELECT filme.titulo, filme.genero, count(locacao.id) AS locacoes
     FROM 
		locacao 
        INNER JOIN cliente ON cliente.id = locacao.id_cliente 
        INNER JOIN filme ON filme.id = locacao.id_filme
	 WHERE cliente.sexo = "M" AND filme.genero = "Ação"
     GROUP BY id_filme) AS mais_locados
WHERE 
	locacoes = (SELECT MAX(locacoes) 
				FROM (SELECT count(locacao.id) AS locacoes 
					  FROM locacao INNER JOIN cliente ON cliente.id = locacao.id_cliente
                      INNER JOIN filme ON filme.id = locacao.id_filme
                      WHERE cliente.sexo = "M" AND filme.genero = "Ação" GROUP BY id_filme) 
			    AS maximo);

-- 9 Qual o filme locado pelo cliente do Id 7, e qual seu nome, e qual a data foi sua data de devolução?
SELECT
	locacao.id_cliente, cliente.nome AS nome_cliente, filme.titulo AS titulo_filme, locacao.dt_devolvido
FROM
	locacao INNER JOIN filme ON filme.id = locacao.id_filme
    INNER JOIN cliente ON cliente.id = locacao.id_cliente
WHERE locacao.id_cliente = 7;
    
-- 10 Quais os filmes foram devolvidos após a data prevista?
SELECT 
	locacao.id AS id_locacao, 
    filme.titulo AS titulo_filme, 
    locacao.dt_devolver, 
    locacao.dt_devolvido, 
    DATEDIFF(locacao.dt_devolvido, locacao.dt_devolver) AS dias_atraso
FROM locacao INNER JOIN filme ON filme.id = locacao.id_filme
WHERE locacao.dt_devolvido > locacao.dt_devolver ;

-- 11 Quantas vezes o filme “The Dark Knight” foi locado?
SELECT  
    filme.titulo AS titulo_filme, 
    COUNT(locacao.id) AS locacoes
FROM locacao INNER JOIN filme ON filme.id = locacao.id_filme
WHERE filme.titulo = "The Dark Knight";

-- 12 Lista dos 5 filmes mais locados em ordem decrescente
SELECT filme.titulo AS titulo_filme, COUNT(locacao.id) AS locacoes
FROM locacao INNER JOIN filme ON filme.id = locacao.id_filme
GROUP BY locacao.id_filme ORDER BY locacoes DESC LIMIT 5;

-- 13 Lista dos 3 clientes com mais locações em ordem decrescente
SELECT cliente.nome, COUNT(locacao.id) AS locacoes
FROM locacao INNER JOIN cliente ON cliente.id = locacao.id_cliente
GROUP BY locacao.id_cliente ORDER BY locacoes DESC LIMIT 3;

-- 14 Lista de filmes que não foram devolvidos
SELECT 
	DISTINCT filme.titulo AS titulo_filme 
FROM locacao INNER JOIN filme ON filme.id = locacao.id_filme 
WHERE dt_devolvido IS NULL;

-- 15 Lista de filmes sem locação
SELECT
	filme.titulo AS titulo_filme,
    locacao.id AS id_locacao
FROM filme LEFT JOIN locacao ON locacao.id_filme = filme.id
WHERE locacao.id IS NULL;

-- INSERÇÕES ##########################################
-- 4 FILMES
	INSERT INTO filme(titulo, id_diretor, genero, ano_lancamento, classificacao_ind) VALUES 
    ("De volta para o futuro 1", 1, "Ação", 1981, 12), 
    ("De volta para o futuro 2", 1, "Ação", 1982, 12), 
    ("Auto-biografia", 2, "Biografia", 1990, 16), 
    ("Novo filme meu", 2, "Comédia", 1990, 10);
    
-- 4 CLIENTES
	INSERT INTO cliente(nome, email, dt_nascimento, cpf, sexo) VALUES 
    ("Thiago Moura", "thiago@email.com", "2005-12-05", "12345678911", "M"), 
    ("Ricardo Silva", "rsilva@email.com", "1990-11-15", "98765432122", "M"), 
    ("Mariana Silveira Pulquerio", "mari.sp@email.com", "1981-02-12", "12347456842", "F"), 
    ("Amy Rose", "amy.rose@email.com", "1976-01-10", "78456127465", "F");
    
-- 4 LOCACOES
	INSERT INTO locacao(id_cliente, id_filme, dt_emprestimo, dt_devolver) VALUES 
    ( 7, 2, "2024-10-15", "2024-10-22"), 
    ( 1, 8, "2024-10-15", "2024-10-16"), 
    ( 4, 1, "2024-10-15", "2024-10-17"), 
    ( 2, 5, "2024-10-15", "2024-10-19");

