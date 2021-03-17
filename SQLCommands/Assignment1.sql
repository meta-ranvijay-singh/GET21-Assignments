/* create storefront database */
create database storefront;

USE storefront;

CREATE TABLE category(
    category_id int PRIMARY KEY,
    category_name varchar(30)
);

CREATE TABLE subcategory(
    subcategory_id int PRIMARY KEY,
    subcategory_name varchar(30),
    category_id int,
    FOREIGN KEY (category_id) REFERENCES category(category_id) ON DELETE CASCADE
);

CREATE TABLE product(
    product_id int PRIMARY KEY,
    product_name varchar(50),
    price decimal(10,2),
    subcategory_id int,
    FOREIGN KEY (subcategory_id) REFERENCES subcategory(subcategory_id) ON DELETE CASCADE
);

CREATE TABLE stock(
    product_id int PRIMARY KEY,
    available int
);

CREATE TABLE orders(
    order_id int PRIMARY KEY,
    order_date date,
    order_status varchar(20)
);

CREATE TABLE items(
    product_id int,
    unit_price decimal(10, 2),
    quantiy int,
    order_id int,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES product(product_id) ON DELETE CASCADE
);

CREATE TABLE shopper(
    shopper_id int PRIMARY KEY,
    name varchar(50),
    email varchar(50),
    address varchar(255)
);

CREATE TABLE shipping_address(
    shipping_address_id int PRIMARY KEY,
    shopper_id int,
    shipping_address varchar(255),
    FOREIGN KEY (shopper_id) REFERENCES shopper(shopper_id)
);

CREATE TABLE shipped(
    shipping_track_id int PRIMARY KEY,
    order_id int,
    shipping_address_id int,
    shipping_status varchar(20),
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (shipping_address_id) REFERENCES shipping_address(shipping_address_id)
);




CREATE TABLE images(
    product_id int,
    image varchar(255),
    FOREIGN KEY (product_id) REFERENCES product(product_id)
);

SHOW TABLES;

SET foreign_key_checks=0;
DROP TABLE product;
SET foreign_key_checks=1;
