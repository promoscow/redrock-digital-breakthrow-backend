create table person
(
    id         bigint auto_increment
        primary key,
    active     int          not null default 1,
    created    datetime     not null default CURRENT_TIMESTAMP,
    updated    datetime     null     default CURRENT_TIMESTAMP,
    gender   varchar(255) null,
    education   varchar(255) null
);
