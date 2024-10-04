## BANCO
<hr>

- `CREATE DATABASE db_name;`
- `DROP DATABASE db_name;`
- `USE db_name;`
- `SHOW TABLES;`
## TABELA
<hr>

###### Criar
`CREATE TABLE tb_name(
	`field_name1 INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`field_name2 CHAR(10) DEFAULT 'ABCDE',
	`field_name3 VARCHAR(40) NOT NULL,
	`FK_id_mae INT NOT NULL,
	`FOREIGN KEY (FK_id_mae) REFERENCES tb_mae(id_mae)
`);
###### Apagar
`DROP TABLE tb_name;`
## Colunas
<hr>

###### Criar
- `ALTER TABLE tb_name ADD COLUMN new_col INT;`
- `ALTER TABLE tb_name ADD COLUMN new_col INT AFTER col_name;`
- `ALTER TABLE tb_name ADD COLUMN new_col INT FIRST;`
###### Excluir
`ALTER TABLE tb_name DROP COLUMN col_name;
###### Alterar
`ALTER TABLE tb_name CHANGE COLUMN old_col new_col VARCHAR(12);`
	Ao alterar colunas com dados, os mesmo são mantidos intactos desde que o tipo do valor não seja alterado.
###### Alterar tipo
`ALTER TABLE tb_name MODIFY COLUMN col_name INT; 
###### Mover de posição
`ALTER TABLE tb_name CHANGE COLUMN col_name col_name VARCHAR(12) AFTER other_col;
`DESCRIBE [bd_name.]tb_name;
###### Adicionar chave primária
- `ALTER TABLE tb_name ADD PRIMARY KEY (col_name);`
###### Adicionar chave estrangeira
- `ALTER TABLE tb_name ADD FOREIGN KEY (this_col_name) REFERENCES tb(fk_col_name);
## REGISTROS
<hr>

- `INSERT INTO tb_name(field_name1, field_name2) VALUE ("value", "value3");`
- `UPDATE tb_name SET field_name = new_value WHERE other_field_from_row = value_to_find;`
- `SELECT field_name FROM tb_name;`
- `SELECT field_name1, field_name2, field_name3 FROM tb_name;`
