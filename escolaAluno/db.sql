CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    sobrenome VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    endereco_id INT NOT NULL
);

INSERT INTO aluno (nome, sobrenome, ano, endereco_id) VALUES ('Juliano', 'Macedo', '6', 4);
INSERT INTO aluno (nome, sobrenome, ano, endereco_id) VALUES ('Paula', 'Cristina', '6', 1);
INSERT INTO aluno (nome, sobrenome, ano, endereco_id) VALUES ('Ricardo', 'Andrade', '6', 2);
INSERT INTO aluno (nome, sobrenome, ano, endereco_id) VALUES ('Helena', 'Duarte', '6', 3);
INSERT INTO aluno (nome, sobrenome, ano, endereco_id) VALUES ('Arthur', 'Duarte', '6', 3);