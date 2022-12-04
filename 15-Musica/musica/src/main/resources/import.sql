INSERT INTO tabela_pais (nome) VALUES ('Estados Unidos');
INSERT INTO tabela_pais (nome) VALUES ('Brasil');
INSERT INTO tabela_pais (nome) VALUES ('Inglaterra');
INSERT INTO tabela_pais (nome) VALUES ('Argentina');
INSERT INTO tabela_pais (nome) VALUES ('México');

INSERT INTO tabela_artista (nome, banda, pais_id) VALUES ('Metallica', true, 1);
INSERT INTO tabela_artista (nome, banda, pais_id) VALUES ('Iron Maiden', true, 3);
INSERT INTO tabela_artista (nome, banda, pais_id) VALUES ('Pearl Jam', true, 1);

INSERT INTO tabela_genero (nome) VALUES ('Rock');
INSERT INTO tabela_genero (nome) VALUES ('Rock Progressivo');
INSERT INTO tabela_genero (nome) VALUES ('Heavy Metal');
INSERT INTO tabela_genero (nome) VALUES ('Trash Metal');
INSERT INTO tabela_genero (nome) VALUES ('Blues');
INSERT INTO tabela_genero (nome) VALUES ('Jazz');
INSERT INTO tabela_genero (nome) VALUES ('Samba');
INSERT INTO tabela_genero (nome) VALUES ('Bossa Nova');
INSERT INTO tabela_genero (nome) VALUES ('Intrumental');

INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Kill ''Em All', 1983, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('The Number of the Beast', 1982, 2, 3);