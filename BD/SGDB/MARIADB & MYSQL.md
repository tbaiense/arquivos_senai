## Instalação e execução
<hr>
###### Debian
1. `sudo apt install mariadb-server`
2. `mariadb -u root`
## Backup
<hr>
###### Exportação
`mariadb-dump --user='root' --add-locks bd_name tb_name > tb_name.sql`
###### Importação
`mariadb --user='root' bd_name < tb_name.sql`
## Comandos do cliente mariadb
<hr>
###### Executar comandos nativos do shell
`\! <comando>;` ou `system <comando>;`
###### Verificar estados da conexão
`\s`
###### Definir `less`como o pager
`\P less` ou `pager less`