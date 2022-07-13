CREATE TABLE endereco (
    id SERIAL PRIMARY KEY,
    rua VARCHAR(255) NOT NULL,
    numero INT NOT NULL
);

INSERT INTO endereco (rua, numero) VALUES ('Rua dos Bandeirantes', 48);
INSERT INTO endereco (rua, numero) VALUES ('Rua Humildes', 1052);
INSERT INTO endereco (rua, numero) VALUES ('Rua Feliz', 365);
INSERT INTO endereco (rua, numero) VALUES ('Rua Muniz', 1152);