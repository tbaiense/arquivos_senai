### Funções que aceitam uso
<pre><code>IN (subquery que resulta em um coluna)</code></pre>

<pre><code>NOT IN ()</code></pre>

### Usando no FROM
<pre><code>SELECT * FROM (SELECT A.col1, A.col2 FROM A WHERE A.col1 < 10) AS tb_name</code></pre>

### Usando no WHERE
<pre><code>SELECT * FROM tb_name WHERE col1 <= (SELECT MAX(col2) FROM tb_name);</code></pre>

### APAGANDO COM SUBQUERY
<pre><code>DELETE
  FROM
    Playlist
  WHERE
    PlaylistId NOT IN (
        SELECT
          DISTINCT PlaylistId
        FROM
          PlaylistTrack
    );</code></pre>