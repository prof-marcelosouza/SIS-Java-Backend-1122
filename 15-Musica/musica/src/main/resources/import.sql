INSERT INTO tabela_pais (nome) VALUES ('Estados Unidos');
INSERT INTO tabela_pais (nome) VALUES ('Brasil');
INSERT INTO tabela_pais (nome) VALUES ('Inglaterra');
INSERT INTO tabela_pais (nome) VALUES ('Argentina');
INSERT INTO tabela_pais (nome) VALUES ('México');

INSERT INTO tabela_estado (nome) VALUES ('Califórnia');
INSERT INTO tabela_estado (nome) VALUES ('East London');
INSERT INTO tabela_estado (nome) VALUES ('Rio Grande do Sul');
INSERT INTO tabela_estado (nome) VALUES ('São Paulo');
INSERT INTO tabela_estado (nome) VALUES ('Rio de Janeiro');
INSERT INTO tabela_estado (nome) VALUES ('Washington');

INSERT INTO tabela_cidade (nome) VALUES ('Los Angeles');
INSERT INTO tabela_cidade (nome) VALUES ('Leyton');
INSERT INTO tabela_cidade (nome) VALUES ('Porto Alegre');
INSERT INTO tabela_cidade (nome) VALUES ('São Paulo');
INSERT INTO tabela_cidade (nome) VALUES ('Rio de Janeiro');
INSERT INTO tabela_cidade (nome) VALUES ('Seattle');

INSERT INTO tabela_genero (nome) VALUES ('Rock');
INSERT INTO tabela_genero (nome) VALUES ('Rock Progressivo');
INSERT INTO tabela_genero (nome) VALUES ('Heavy Metal');
INSERT INTO tabela_genero (nome) VALUES ('Trash Metal');
INSERT INTO tabela_genero (nome) VALUES ('Blues');
INSERT INTO tabela_genero (nome) VALUES ('Jazz');
INSERT INTO tabela_genero (nome) VALUES ('Samba');
INSERT INTO tabela_genero (nome) VALUES ('Bossa Nova');
INSERT INTO tabela_genero (nome) VALUES ('Intrumental');

INSERT INTO tabela_artista (nome, banda, pais_id, estado_id, cidade_id) VALUES ('Metallica', true, 1, 1, 1);
INSERT INTO tabela_artista (nome, banda, pais_id, estado_id, cidade_id) VALUES ('Iron Maiden', true, 3, 2, 2);
INSERT INTO tabela_artista (nome, banda, pais_id, estado_id, cidade_id) VALUES ('Pearl Jam', true, 1, 6, 6);

INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Kill ''Em All', 1983, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Ride The Lightning', 1984, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Master Of Puppets', 1986, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('... And Justice For All', 1988, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Metallica', 1991, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Load', 1996, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('ReLoad', 1997, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Garage Inc', 1998, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('St. Anger', 2003, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Death Magnetic', 2008, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('Hardwired--- to Self-Desctruct', 2016, 1, 4);
INSERT INTO tabela_album (titulo, ano, artista_id, genero_id) VALUES ('The Number of the Beast', 1982, 2, 3);