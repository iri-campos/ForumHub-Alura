CREATE TABLE login (
    id BIGINT not null AUTO_INCREMENT,
    login VARCHAR(100) not null,
    senha VARCHAR(255) not null,

    primary key (id)
);