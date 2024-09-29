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

-- 8 Qual artista ficou mais vezes no top 1
SELECT nomeArtista, SUM(vezesMaiorPosicao) AS TOP1_TOTAL
FROM spotifytop
WHERE maiorPosicao = 1
GROUP BY nomeArtista ORDER BY TOP1_TOTAL DESC
LIMIT 1;

-- 9 Qual artistas possui mais registros
SELECT nomeArtista, COUNT(nomeMusica) AS QTD_MUSICAS
FROM spotifytop
GROUP BY nomeArtista
ORDER BY QTD_MUSICAS DESC
LIMIT 1;

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

-- 17 Quais são os 5 artistas com mais registros, de forma decrescente
SELECT nomeArtista, COUNT(nomeMusica) AS QTD_MUSICAS
FROM spotifytop
GROUP BY nomeArtista
ORDER BY QTD_MUSICAS
LIMIT 5;

-- 18 Qual o total de streams das 10 músicas mais com mais streams
SELECT
    SUM(totalStreams) AS totalStreamsTop10
FROM
    (SELECT
            nomeMusica, totalStreams
        FROM
            spotifytop
        WHERE
            totalStreams IS NOT NULL
        ORDER BY totalStreams DESC
        LIMIT 10) AS StreamsTop10;

-- 19 Quais as músicas que já estiveram no top 1 e estiveram entre 40 e 60 vezes a maior posição
SELECT nomeMusica, maiorPosicao, vezesMaiorPosicao
FROM spotifytop
WHERE maiorPosicao = 1 AND vezesMaiorPosicao BETWEEN 40 AND 60
ORDER BY vezesMaiorPosicao DESC;

-- 20 Quais músicas tiveram menos de 500 mil streams e ficaram entre o top 5 e 10
SELECT nomeMusica, totalStreams, maiorPosicao
FROM spotifytop
WHERE totalStreams < 500000 AND maiorPosicao BETWEEN 5 AND 10
ORDER BY totalStreams DESC;

-- 21 Qual a música com o mínimo de streams que atingiu a 1° posição no top 10
SELECT nomeMusica, totalStreams, maiorPosicao
FROM spotifytop
WHERE totalStreams = (SELECT MIN(totalStreams) FROM spotifytop WHERE maiorPosicao = 1);

-- 22 Qual a música com o mínimo de streams da artista Taylor Swift
SELECT nomeMusica, nomeArtista, totalStreams
FROM spotifytop
WHERE totalStreams = (
	SELECT MIN(totalStreams)
    FROM spotifytop
    WHERE nomeArtista = "Taylor Swift");

SELECT maiorPosicao, SUM(totalStreams), COUNT(posicao)
FROM spotifytop
WHERE totalStreams < 100000
GROUP BY maiorPosicao
HAVING maiorPosicao BETWEEN MIN(posicao) AND MAX(posicao)
ORDER BY maiorPosicao ASC;
