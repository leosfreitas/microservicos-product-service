CREATE TABLE IF NOT EXISTS product.product (
    id_product VARCHAR(255) PRIMARY KEY,
    tx_name VARCHAR(255) NOT NULL,
    db_price NUMERIC(10, 2) NOT NULL,
    tx_unit VARCHAR(50) NOT NULL,
    dt_creation TIMESTAMP NOT NULL
);