USE SPOTIFYNEW;
-- 1 Contagem de quantos Artistas estão com valor Nulo no nome
SELECT COUNT(nomeArtista) FROM spotifytop
WHERE nomeArtista IS NULL;

-- 2 Contagem total de quantos registros tem na tabela
SELECT COUNT(posicao) FROM spotifytop;

-- 3 Contagem de quantas músicas estiveram no top 1
SELECT COUNT(maiorPosicao) AS QTD_MUSICAS FROM spotifytop
WHERE maiorPosicao = 1; 

-- 4 Qual a música que ficou por mais vezes no top 1
SELECT nomeArtista, nomeMusica, maiorPosicao, vezesMaiorPosicao FROM spotifytop
WHERE vezesMaiorPosicao = (
	SELECT MAX(vezesMaiorPosicao) FROM spotifytop
    WHERE maiorPosicao = 1);
    
-- 5 Quantos artistas diferentes há
SELECT COUNT(DISTINCT nomeArtista) AS QTD_ARTISTAS FROM spotifytop;

-- 6 Qual música com mais streams
SELECT nomeMusica, nomeArtista, totalStreams FROM spotifytop
WHERE totalStreams = (SELECT MAX(totalStreams) FROM spotifytop);


-- 7 Qual música com maior pico de streams
SELECT nomeMusica, nomeArtista, picoDeStreams FROM spotifytop
WHERE picoDeStreams = (SELECT MAX(picoDeStreams) FROM spotifytop);

-- X  8 Qual artista ficou mais vezes no top 1
SELECT nomeArtista, SUM(vezesMaiorPosicao) FROM spotifytop
GROUP BY nomeArtista;


-- X9 Qual artistas possui mais registros
SELECT nomeArtista, COUNT(nomeMusica) as QTD_VEZES FROM spotifytop
GROUP BY nomeArtista order by QTD_VEZES DESC;

-- 10 Quantos artistas possuem nome iniciando com a letra “H”
SELECT COUNT(nomeArtista) AS QTD_ARTISTAS FROM spotifytop
WHERE nomeArtista LIKE 'H%';

-- 11 Quais as músicas da artista “Anitta” estão na tabela?
SELECT nomeMusica, nomeArtista FROM spotifytop
WHERE nomeArtista = "Anitta";

-- 12 Quantas músicas passaram da marca de 500 mil streams
SELECT COUNT(nomeMusica) as QTD_MUSICAS FROM spotifytop
WHERE totalStreams > 500000;

-- 13 Qual a música no registro 3480
SELECT nomeMusica, nomeArtista, posicao FROM spotifytop
WHERE posicao = 3480;

-- 14 Quantas músicas o artista “The Weeknd” possui e quais
SELECT nomeArtista, nomeMusica FROM spotifytop
WHERE nomeArtista = "The Weeknd" ORDER BY nomeMusica;

SELECT COUNT(nomeArtista) AS QTD_MUSICAS FROM spotifytop
WHERE nomeArtista = "The Weeknd";

-- 15 Quantas músicas possuem “girl” no nome
SELECT COUNT(nomeMusica) AS QTD_MUSICAS FROM spotifytop
WHERE nomeMusica LIKE '%girl%';

-- 16 Qual o total de streams do artista “Post Malone”
SELECT SUM(totalStreams) AS TOTAL_STREAMS FROM spotifytop
WHERE nomeArtista = "Post Malone";

