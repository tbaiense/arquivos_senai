CREATE TABLE produto(
	nome VARCHAR(32),
	caracteristica VARCHAR(32),
	categoria VARCHAR(32),
	cidade VARCHAR(32),
	codigo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(32),
	dt_fabricacao VARCHAR(32),
	dt_validade VARCHAR(32),
	estado VARCHAR(32),
	estoque VARCHAR(32),
	fabricante VARCHAR(32),
	fornecedor VARCHAR(32),
	pais VARCHAR(32),
	peso VARCHAR(32),
	preco_custo VARCHAR(32),
	preco_venda VARCHAR(32),
	rua VARCHAR(32),
	unidade VARCHAR(32),
	unidade_peso VARCHAR(32),
    usuario_autor varchar(32)
);

DESCRIBE produto;
