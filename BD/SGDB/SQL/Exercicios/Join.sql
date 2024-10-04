SELECT * FROM livros;
SELECT * FROM autores;

-- Inner Join, só exibe registros correspondentes
SELECT l.titulo, a.`name`
FROM livros l
INNER JOIN autores a
ON a.autor_id = l.autor_id
;

-- left join, juntar registros que possuam ou nao correspondentes
SELECT l.titulo, a.`name`
FROM livros l 
LEFT JOIN autores a ON a.autor_id = l.autor_id;

-- right join, juntar registros que possuam ou nao correspondentes
SELECT l.titulo, a.`name`
FROM livros l 
RIGHT JOIN autores a ON a.autor_id = l.autor_id;

-- CROSS JOIN
SELECT l.titulo, a.`name`
FROM livros l CROSS JOIN autores a;

-- left ex join
SELECT l.titulo, a.`name`
FROM livros l 
LEFT JOIN autores a ON a.autor_id = l.autor_id
WHERE a.autor_id IS NULL;

-- right ex join
SELECT l.titulo, a.`name`
FROM livros l 
RIGHT JOIN autores a ON a.autor_id = l.autor_id
WHERE l.autor_id IS NULL;

-- outer join (full join)
SELECT l.titulo, a.`name`
FROM livros l LEFT JOIN autores a
ON a.autor_id = l.autor_id
		UNION 
SELECT l.titulo, a.`name`
FROM livros l 
RIGHT JOIN autores a ON a.autor_id = l.autor_id;

-- outer excluding join
SELECT l.titulo, a.`name`
FROM livros l 
LEFT JOIN autores a ON a.autor_id = l.autor_id
WHERE a.autor_id IS NULL
		UNION
SELECT l.titulo, a.`name`
FROM livros l
RIGHT JOIN autores a ON a.autor_id = l.autor_id
WHERE l.autor_id IS NULL;

-- inner join de tres tables
SELECT l.titulo, a.`name`, g.name
FROM livros l
INNER JOIN autores a ON a.autor_id = l.autor_id
INNER JOIN generos g ON g.genero_id = l.genero_id
;
