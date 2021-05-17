INSERT INTO product_type (id_product_type, product_type_name) VALUES (1, 'Bienes de consumo')
INSERT INTO product_type (id_product_type, product_type_name) VALUES (2, 'Servicios')
INSERT INTO product_type (id_product_type, product_type_name) VALUES (3, 'Bienes de uso común')
INSERT INTO product_type (id_product_type, product_type_name) VALUES (4, 'Bienes de emergencia')
INSERT INTO product_type (id_product_type, product_type_name) VALUES (5, 'Bienes durables')
INSERT INTO product_type (id_product_type, product_type_name) VALUES (6, 'Bienes de especialidad')
INSERT INTO product_type (id_product_type, product_type_name) VALUES (7, 'Otros')

INSERT INTO product (id_product,reference, product_name, id_product_type, stock, is_active) VALUES (1, 'REF-001', 'Portatil', 5, 55, true)
INSERT INTO product (id_product,reference, product_name, id_product_type, stock, is_active) VALUES (2, 'REF-002', 'Alcohol', 4, 100, true)
INSERT INTO product (id_product,reference, product_name, id_product_type, stock, is_active) VALUES (3, 'REF-003', 'Libro', 1, 200, true)

INSERT INTO transaction_product(id_transaction, id_product, in_stock, out_stock, modification_date) VALUES (1, 1, 55, 0, '2021-05-12')
INSERT INTO transaction_product(id_transaction, id_product, in_stock, out_stock, modification_date) VALUES (2, 2, 100, 0, '2019-03-02')
INSERT INTO transaction_product(id_transaction, id_product, in_stock, out_stock, modification_date) VALUES (3, 3, 200, 0, '2021-05-10')

INSERT INTO roles (id_role, role_name) values (1,'ROLE_ADMIN')
INSERT INTO roles (id_role, role_name) values (2,'ROLE_CONSULTATION')

INSERT INTO users (id_user, user_name, password, enabled) VALUES (1, 'admin','$2y$12$ZbdrnGIjSbA8G9YIjxl8k.uM0F4tSB3GzUqdNBQ7LXsXvc8mdIIU.',true)
INSERT INTO users (id_user, user_name, password, enabled) VALUES (2,'anonimus','$2y$12$zKMmiurB4d2av.dtg9sts.5eipBHdagWPyGpBhYOzi3Bqgpf8yIV.', true)

INSERT INTO users_authorities (id_user, id_rol ) values (1,1)
INSERT INTO users_authorities (id_user, id_rol ) values (2,2)



