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

INSERT INTO state(name) VALUES ('Minas Gerais');
INSERT INTO state(name) VALUES ('São Paulo');
INSERT INTO state(name) VALUES ('Rio de Janeiro');

INSERT INTO city(name, estado_id) VALUES ('Uberlândia',1);
INSERT INTO city(name, estado_id) VALUES ('São Paulo',2);
INSERT INTO city(name, estado_id) VALUES ('Campinas',2);
INSERT INTO city(name, estado_id) VALUES ('Rio de Janeiro',3);
INSERT INTO city(name, estado_id) VALUES ('Itaguaí',3);
