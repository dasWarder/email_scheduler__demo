DROP TABLE IF EXISTS customer;
DROP SEQUENCE IF EXISTS customer_seq;

CREATE SEQUENCE customer_seq START WITH 1;

CREATE TABLE customer (
    id INT NOT NULL PRIMARY KEY DEFAULT nextval('customer_seq'),
    email VARCHAR(100) NOT NULL,
    name VARCHAR(65) NOT NULL
);

CREATE UNIQUE INDEX email_id_index ON customer(id, email);