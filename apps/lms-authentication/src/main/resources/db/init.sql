create table users
(
    id bigserial
        constraint users_pk
            primary key,
    username varchar not null,
    password varchar not null,
    fullname varchar not null,
    email varchar not null,
    is_activated bool not null
);

create unique index users_email_uindex
    on users (email);

create unique index users_username_uindex
    on users (username);

insert into users(username, password, fullname, email, is_activated) values ('admin', 'admin', 'Administrator', 'admin@gmail.com', true);
