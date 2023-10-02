DROP SCHEMA IF EXISTS spring;

DROP USER IF EXISTS 'user'@'localhost';

CREATE SCHEMA spring;

CREATE USER 'user'@'localhost' IDENTIFIED BY 'pass123';

GRANT SELECT, INSERT, DELETE, UPDATE ON spring.* TO 'user'@'localhost';

USE spring;

CREATE TABLE usr_usuario (
    usr_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    usr_nome VARCHAR(20) NOT NULL,
    usr_senha VARCHAR(150) NOT NULL,
    PRIMARY KEY (usr_id),
    UNIQUE KEY uni_usuario_nome (usr_nome)
);

CREATE TABLE aut_autorizacao (
    aut_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    aut_nome VARCHAR(20) NOT NULL,
    PRIMARY KEY (aut_id),
    UNIQUE KEY uni_aut_nome (aut_nome)
);

CREATE TABLE uau_usuario_autorizacao (
    usr_id BIGINT UNSIGNED NOT NULL,
    aut_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (usr_id, aut_id),
    FOREIGN KEY (usr_id) REFERENCES usr_usuario (usr_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (aut_id) REFERENCES aut_autorizacao (aut_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

CREATE TABLE ant_anotacao (
    ant_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    ant_texto VARCHAR(256) NOT NULL,
    ant_data_hora DATETIME NOT NULL,
    ant_usr_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (ant_id),
    FOREIGN KEY (ant_usr_id) REFERENCES usr_usuario (usr_id)
);

INSERT INTO usr_usuario (usr_nome, usr_senha)
VALUES ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');

INSERT INTO aut_autorizacao (aut_nome)
VALUES ('ROLE_ADMIN');

INSERT INTO uau_usuario_autorizacao (usr_id, aut_id)
VALUES (1, 1);

INSERT INTO ant_anotacao (ant_texto, ant_data_hora, ant_usr_id)
VALUES ('Meu novo projeto', '2023-08-01 19:10', 1);