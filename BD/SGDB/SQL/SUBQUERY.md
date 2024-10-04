### Funções que aceitam uso
<pre><code>IN (subquery que resulta em um coluna)</code></pre>
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