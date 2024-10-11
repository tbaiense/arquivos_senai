### GROUP BY 
Agrupa resultados em grupos de acordo com o que for especificado:

<pre><code>SELECT
	nome_aluno, AVG(nota_aluno) AS nota_media
FROM alunos
GROUP BY nome_aluno</code></pre>

### HAVING
Serve para filtrar o que será exibido do resultado agrupado, portanto vem após o WHERE.
O HAVING consegue se referir a aliases de colunas.