SELECT * FROM mysql.user;
SELECT * FROM mysql.db;
SELECT * FROM mysql.tables_priv;
SELECT * FROM mysql.columns_priv;

-- CRIAR USUARIO
CREATE USER 'thiago'@'localhost';
CREATE USER 'adm'@'localhost' IDENTIFIED BY '1234';

-- DELETAR USUARIO
DROP USER 'thiago'@'localhost';

-- EXIBE A OPÇÃO DE PRIVILÉGIO DE UM USUARIO
SHOW GRANTS FOR 'adm'@'localhost';

-- CONCEDER TODAS AS PERMISSOES A UM USUARIO
GRANT ALL ON japedidos.* TO 'adm'@'localhost';
GRANT ALL ON japedidos.* TO 'adm'@'localhost' WITH GRANT OPTION; /* Permite a criação de usuarios */
-- CONCEDER PERMISSAO DE CREATE
GRANT CREATE ON tb_name.* TO 'adm'@'localhost';
GRANT SELECT, UPDATE, DELETE ON tb_name.* TO 'adm'@'localhost';

-- REVOGAR TODOS AS PERMISSOES
REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'adm'@'localhost';

-- RECARREGA OS PRIVILEGIOS
FLUSH PRIVILEGES;

