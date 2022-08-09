--liquibase formatted sql

--changeset i.m: 1
create table document(
    id uuid primary key,
    document_date date
);

--changeset i.m: 2
create table dictionary(
    id uuid primary key,
    name varchar
);

--changeset i.m: 3
create table test(
    id uuid primary key,
    document_id uuid references document(id),
    dictionary_id uuid references dictionary(id),
    name varchar
);