CREATE TABLE estado
(
    id   bigint      not null auto_increment,
    nome varchar(80) not null,

    primary key (id)
) engine = InnoDB
  default charset = UTF8MB4;

INSERT INTO estado(nome)
SELECT DISTINCT nome_estado
FROM cidade;

ALTER TABLE cidade
    ADD COLUMN estado_id BIGINT NOT NULL;

UPDATE cidade c
SET c.estado_id = (select e.id from estado e where e.nome = c.nome_estado);

ALTER TABLE cidade
    ADD CONSTRAINT fk_cidade_estado
        FOREIGN KEY (estado_id)
            REFERENCES estado (id);

ALTER TABLE cidade
    DROP COLUMN nome_estado;

ALTER TABLE cidade
    CHANGE COLUMN nome_cidade nome VARCHAR(80) NOT NULL;