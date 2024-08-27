create table stores(

id BIGSERIAL ,
name text,
tenantId text,
primary key(id)
);


create table customers(

id BIGSERIAL ,
name text,
email_id text,
password varchar(200),
store_id BIGSERIAL REFERENCES stores(id),
primary key(id)
);