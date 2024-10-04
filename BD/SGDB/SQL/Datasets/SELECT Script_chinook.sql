-- REGISTROS EM Playlist que deverão ser excluídos: 1, 5, 8, 10

DELETE
  FROM
    Playlist
  WHERE
    PlaylistId NOT IN (
        SELECT
          DISTINCT PlaylistId
        FROM
          PlaylistTrack
    );


-- Quantidade de playlists que cada música está
SELECT
  t.Name AS Track_Name,
  COUNT(p.PlaylistId) AS PlaylistCount
FROM
  Track AS t INNER JOIN PlaylistTrack AS p
    ON p.TrackId = t.TrackId
GROUP BY TrackId;
