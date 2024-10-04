DESCRIBE bebe;
DESCRIBE medico;
DESCRIBE mae;

INSERT INTO medico(nome_medico, crm_medico, especialidade) VALUES 
	("Mario", "11457", "Geral"),
    ("Lucas", "100", "Geral"),
    ("Jucelino", "78965", "Pediatra"),
    ("Marta", "114", "Geral")
;

INSERT INTO mae(nome, endereco, dt_nasc, telefone) VALUES 
	("Luana Ribeiro", "Vitória", "2002-10-23", "111223344"),
    ("Juana Osvando", "Vila-Velha", "1970-05-3", "7788996655")
;

SELECT * FROM bebe;

UPDATE bebe
SET nome="mariazinha"
WHERE id_bebe=3;

SELECT 
	b.nome AS nome_bebe ,
	mae.nome,
	m.nome_medico,
	m.crm_medico,
	m.especialidade
FROM bebe b
	INNER JOIN medico m
		ON m.id_medico = b.medico_id
	INNER JOIN mae
		ON mae.id_mae = b.mae_id;