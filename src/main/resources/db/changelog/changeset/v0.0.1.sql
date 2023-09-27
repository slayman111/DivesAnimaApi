CREATE TABLE roles
(
    id    INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    value VARCHAR(50) NOT NULL
);

INSERT INTO roles (value)
VALUES ('USER');

INSERT INTO roles (value)
VALUES ('ADMIN');

CREATE TABLE users
(
    id       INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    login    VARCHAR(255) UNIQUE                   NOT NULL,
    password VARCHAR(255)                          NOT NULL,
    role_id  INT
        CONSTRAINT fk_users_roles REFERENCES roles NOT NULL
);
