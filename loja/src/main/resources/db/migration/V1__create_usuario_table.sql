CREATE SCHEMA if NOT EXISTS usuario;

CREATE TABLE usuario.usuario(
    id bigserial PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(100) NOT NULL,
    data_cadastro TIMESTAMP NOT NULL 
);