## Instalação e execução
<hr>
###### Debian
1. `sudo apt install mariadb-server`
2. `sudo mariadb -u root`
## Backup
<hr>
##### Exportação
`mariadb-dump --user='root' --add-locks bd_name tb_name > tb_name.sql`
###### Importação
`mariadb --user='root' bd_name < tb_name.sql`
## Configuração
<hr>
###### Caminhos dos arquivos de config. no Debian
- /etc/mysql/my.cnf
- etc/mysql/mariadb.conf.d/50-server.cnf
## [Habilitando acesso remoto](https://mariadb.com/kb/en/configuring-mariadb-for-remote-client-access/)
<hr>
###### 1. Acessar o banco:
`sudo mariadb -u root`
###### 2. Verificar usuários:
`SELECT User,Host FROM mysql.user;`
###### 3. Habilitar usuário root a acessar o banco:
`GRANT ALL PRIVILEGES ON *.* TO 'root'@'10.0.0.%' IDENTIFIED BY 'mypassword' WITH GRANT OPTION;
###### 4. Alterar parâmetro de configuração `bind-address`:
- `sudo vim etc/mysql/mariadb.conf.d/50-server.cnf`
- Alterar `bind-address = 127.0.0.1` para `bind-address = 10.0.0.107`
###### 5. Reiniciar serviço `mysqld.service`:
`sudo systemctl restart mysqld.service`
###### 6. Verificar configuração carregada:
`sudo mariadbd --print-defaults`
###### 7. Conectar usando IP (Cliente):
`sudo mariadb -u root -p [banco_conectar] -h 10.0.0.107`
## Comandos do cliente mariadb
<hr>
###### Executar comandos nativos do shell
`\! <comando>;` ou `system <comando>;`
###### Verificar estados da conexão
`\s`
###### Definir `less`como o pager
`\P less` ou `pager less`