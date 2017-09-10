CREATE TABLE titulares (
    nro_titular BIGINT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    rg VARCHAR(32) NOT NULL,
    cpf VARCHAR(32) NOT NULL,
    PRIMARY KEY (nro_titular)
);

INSERT INTO titulares VALUES (2, 'Marcos Antônio', '22333444','09988877765');
INSERT INTO titulares VALUES (3, 'Rosimeire Aparecida', '11222333','08866655543');
INSERT INTO titulares VALUES (4, 'Roberto Carlos', '33444555','07755544432');
INSERT INTO titulares VALUES (5, 'André Barros', '44555666','06655533321');
