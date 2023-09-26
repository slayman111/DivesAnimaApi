create table roles
(
    id    int primary key generated always as identity,
    value varchar(50)
);

insert into roles (value) values ('USER');
insert into roles (value) values ('ADMIN');

create table users
(
    id       int primary key generated always as identity,
    login    varchar(255) unique not null,
    password varchar(255)        not null,
    role_id  int
        constraint fk_users_roles references roles
);