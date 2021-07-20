INSERT INTO category(name) VALUES ('Informática');
INSERT INTO category(name) VALUES ('Escritório');
INSERT INTO category(name) VALUES ('Eletrônicos');

INSERT INTO product(name,price) VALUES ('Computador',2000.00);
INSERT INTO product(name,price) VALUES ('Impressora',800.00);
INSERT INTO product(name,price) VALUES ('Mouse',80.00);

INSERT INTO product_category(products_id,categories_id) VALUES (1,1);
INSERT INTO product_category(products_id,categories_id) VALUES (2,1);
INSERT INTO product_category(products_id,categories_id) VALUES (2,2);
INSERT INTO product_category(products_id,categories_id) VALUES (3,1);
