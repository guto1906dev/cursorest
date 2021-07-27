INSERT INTO category(name) VALUES ('Informática');
INSERT INTO category(name) VALUES ('Escritório');
INSERT INTO category(name) VALUES ('Cama Mesa e Banho');
INSERT INTO category(name) VALUES ('Eletrônicos');
INSERT INTO category(name) VALUES ('Jardinagem');
INSERT INTO category(name) VALUES ('Decoração');
INSERT INTO category(name) VALUES ('Perfumaria');


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

INSERT INTO client(cpf_ou_cnpj, email, name, tipo) VALUES ('00000000001', 'maria@gmail.com','Maria',1);
INSERT INTO client(cpf_ou_cnpj, email, name, tipo) VALUES ('00000000002', 'fazendo@gmail.com','Fazendo Arte',2);

INSERT INTO address(cep, district, number, public_place, city_id, client_id) VALUES ('00000001', 'Centro1', '31', 'rua1',1,1);
INSERT INTO address(cep, district, number, public_place, city_id, client_id) VALUES ('00000002', 'Centro2', '32', 'rua2',2,1);
INSERT INTO address(cep, district, number, public_place, city_id, client_id) VALUES ('00000003', 'Centro3', '33', 'rua3',3,2);

INSERT INTO phone(client_id, phones) VALUES (1, 21000000001);
INSERT INTO phone(client_id, phones) VALUES (1, 21000000002);
INSERT INTO phone(client_id, phones) VALUES (2, 21000000003);

INSERT INTO pedido(instant, cliente_id, endereco_entrega_id) VALUES (TIMESTAMP '2017-09-30 10:32',1, 1);
INSERT INTO payment(pedido_id, estado) VALUES(1,2);
INSERT INTO card_payment(numero_de_parcelas, pedido_id) VALUES (6,1);

INSERT INTO pedido(instant, cliente_id, endereco_entrega_id) VALUES (TIMESTAMP '2017-09-30 11:32',2, 3);
INSERT INTO payment(pedido_id, estado) VALUES(2,1);
INSERT INTO payment_with_bank_slip(data_vencimento, pedido_id) VALUES (TIMESTAMP '2017-10-20',2);

INSERT INTO item_pedido(desconto, preco, quantidade, pedido_id, product_id) VALUES(0, 200, 1, 1, 1);
INSERT INTO item_pedido(desconto, preco, quantidade, pedido_id, product_id) VALUES(0, 80, 2, 1, 3);
INSERT INTO item_pedido(desconto, preco, quantidade, pedido_id, product_id) VALUES(100, 800, 1, 2, 2);



