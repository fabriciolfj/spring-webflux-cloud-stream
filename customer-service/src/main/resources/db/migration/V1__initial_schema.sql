CREATE table customer (
id bigserial primary key not null,
created_date bigint not null,
last_modified_date bigint not null,
version integer not null,
name varchar(255) not null,
code varchar(255) not null,
status varchar(10) not null,
document varchar(255) not null
);

CREATE UNIQUE INDEX idx_customer
ON customer(code);