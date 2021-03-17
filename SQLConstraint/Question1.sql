/*
Table       :category
Constraints :
primary key :category_id
*/
ALTER TABLE category
MODIFY COLUMN category_id int PRIMARY KEY;

/*
Table       :images
Constraints :
foreign key :product_id
*/
ALTER TABLE images
ADD CONSTRAINT fk_product_id
FOREIGN KEY (product_id) REFERENCES product(product_id);

/*
Table       :items
Constraints :
foreign key :order_id, product_id
*/
ALTER TABLE items
ADD CONSTRAINT fk_order_id
FOREIGN KEY (order_id) REFERENCES orders(order_id);

ALTER TABLE items
ADD CONSTRAINT fk_product_id
FOREIGN KEY (product_id) REFERENCES product(product_id);

/*
Table       :orders
Constraints :
primary key :order_id
foreign key :shopper_id
*/
ALTER TABLE orders
MODIFY COLUMN order_id int PRIMARY KEY;

ALTER TABLE orders
ADD CONSTRAINT fk_shopper_id
FOREIGN KEY (shopper_id) REFERENCES shopper(shopper_id);

/*
Table       :product
Constraints :
primary key :product_id
foreign key :subcategory_id
*/
ALTER TABLE product
MODIFY COLUMN product_id int PRIMARY KEY;

ALTER TABLE product
ADD CONSTRAINT fk_subcategory_id
FOREIGN KEY (subcategory_id) REFERENCES subcategory(subcategory_id);

/*
Table       :shipped
Constraints :
primary key :shipping_track_id
foreign key :shipping_address_id, order_id
*/
ALTER TABLE shipped
MODIFY COLUMN shipping_track_id int PRIMARY KEY;

ALTER TABLE shipped
ADD CONSTRAINT fk_shipping_address_id
FOREIGN KEY (shipping_address_id) REFERENCES shipping_address(shipping_address_id);

ALTER TABLE shipped
ADD CONSTRAINT fk_order_id
FOREIGN KEY (order_id) REFERENCES orders(order_id);

/*
Table       :shipping_address
Constraints :
primary key :shipping_address_id
foreign key :shopper_id
*/
ALTER TABLE shipping_address
MODIFY COLUMN shipping_address_id int PRIMARY KEY;

ALTER TABLE shipping_address
ADD CONSTRAINT fk_shopper_id
FOREIGN KEY (shopper_id) REFERENCES shopper(shopper_id);

/*
Table       :shopper
Constraints :
primary key :shopper_id
*/
ALTER TABLE shopper
MODIFY COLUMN shopper_id int PRIMARY KEY;

/*
Table       :stock
Constraints :
primary key :product_id
*/
ALTER TABLE stock
MODIFY COLUMN product_id int PRIMARY KEY;

/*
Table       :subcategory
Constraints :
primary key :subcategory_id
foreign key :category_id
*/
ALTER TABLE subcategory
MODIFY COLUMN subcategory_id int PRIMARY KEY;

ALTER TABLE subcategory
ADD CONSTRAINT fk_category_id
FOREIGN KEY (category_id) REFERENCES category(category_id);