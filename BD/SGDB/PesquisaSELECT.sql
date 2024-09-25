USE SPOTIFYNEW;

SELECT * FROM spotifytop;
SELECT nomeMusica, nomeArtista FROM spotifytop;

SELECT nomeArtista, nomeMusica FROM spotifytop
WHERE nomeArtista = "Madonna";

-- Contar resultados selecionados
SELECT COUNT(nomeMusica) AS contagem FROM spotifytop
WHERE nomeArtista = "Post Malone";

SELECT nomeMusica, top10Vezes FROM spotifytop
WHERE top10Vezes <> 0;

SELECT nomeMusica, maiorPosicao FROM spotifytop
WHERE maiorPosicao <= 10;

SELECT nomeArtista, nomeMusica, picoDeStreams FROM spotifytop
WHERE picoDeStreams > 5000000;

SELECT nomeArtista, nomeMusica, picoDeStreams FROM spotifytop
WHERE picoDeStreams BETWEEN 5000000 AND 6000000;

SELECT nomeArtista, nomeMusica, picoDeStreams FROM spotifytop
WHERE picoDeStreams NOT BETWEEN 5000000 AND 6000000;

SELECT nomeArtista, nomeMusica FROM spotifytop
WHERE nomeArtista IN ("Madonna", "Drake", "Eminem");

SELECT nomeMusica, top10Vezes FROM spotifytop
WHERE top10Vezes IN (1, 2);

SELECT nomeMusica, nomeArtista FROM spotifytop
WHERE nomeArtista LIKE"michael%J%";

SELECT nomeMusica, nomeArtista, totalStreams FROM spotifytop
WHERE totalStreams IS NULL;

SELECT nomeMusica, nomeArtista, totalStreams FROM spotifytop
WHERE totalStreams IS NOT NULL;

SELECT nomeMusica, nomeArtista, totalStreams FROM spotifytop
WHERE totalStreams > 100000 AND nomeArtista LIKE "%ed";

SELECT nomeMusica, nomeArtista, totalStreams FROM spotifytop
WHERE totalStreams > 100000 OR nomeArtista ="Jão";

SELECT nomeArtista, nomeMusica, picoDeStreams FROM spotifytop
WHERE nomeArtista = "Michael Jackson"
ORDER BY nomeMusica DESC;

SELECT nomeArtista, nomeMusica, picoDeStreams FROM spotifytop
WHERE nomeArtista = "Michael Jackson"
ORDER BY picoDeStreams ASC;

SELECT nomeMusica, dias, maiorPosicao FROM spotifytop
WHERE maiorPosicao = 1
ORDER BY dias ASC;

SELECT AVG(maiorPosicao) as Media_posicoes FROM spotifytop;

SELECT AVG(totalStreams) as mediaStreams, count(nomeArtista) AS QTD_ARTISTAS FROM spotifytop
WHERE nomeArtista = "Post Malone";

SELECT nomeArtista, nomeMusica, picoDeStreams FROM spotifytop
WHERE picoDeStreams = (SELECT MAX(picoDeStreams) FROM spotifytop);


SELECT nomeArtista, nomeMusica, picoDeStreams FROM spotifytop
WHERE picoDeStreams = (SELECT MIN(picoDeStreams) FROM spotifytop 
							WHERE picoDeStreams >= (
								SELECT AVG(picoDeStreams) FROM spotifytop));
                                
SELECT SUM(totalStreams) AS total FROM spotifytop
WHERE nomeArtista = "Taylor Swift";

SELECT posicao FROM spotifytop
WHERE totalStreams = (SELECT MIN(totalStreams) FROM spotifytop);

-- Retorna os nomes diferentes
SELECT DISTINCT nomeArtista FROM spotifytop;

SELECT COUNT(DISTINCT nomeArtista) AS Artistas_diferentes FROM spotifytop;

SELECT nomeArtista, COUNT(nomeMusica) as QTD_VEZES FROM spotifytop
GROUP BY nomeArtista;

SELECT nomeArtista, COUNT(nomeMusica) as QTD_VEZES FROM spotifytop
GROUP BY nomeArtista
ORDER BY QTD_VEZES DESC;

SELECT nomeArtista, COUNT(nomeMusica) as QTD_VEZES FROM spotifytop
GROUP BY nomeArtista
HAVING QTD_VEZES > 100;

DELETE FROM spotifytop
WHERE nomeArtista LIKE "anni%";