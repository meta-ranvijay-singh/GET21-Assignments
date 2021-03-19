/*
Identify the columns require indexing in order, product, category tables and create indexes.
*/

/*
Table       :orders
*/

EXPLAIN EXTENDED SELECT order_id, order_date, order_status
FROM orders
WHERE order_date = '2021-02-10'
GROUP BY order_status
ORDER BY order_date;

ALTER TABLE orders ADD INDEX order_date_index(order_date);

EXPLAIN EXTENDED SELECT order_id, order_date, order_status
FROM orders
WHERE order_date = '2021-02-10'
GROUP BY order_status
ORDER BY order_date;

/*
Table       :product
*/

EXPLAIN EXTENDED SELECT product_id, product_name, price
FROM product
WHERE product_name = 'RedmiY2'
ORDER BY product_name;

ALTER TABLE product ADD INDEX product_name_index(product_name);

EXPLAIN EXTENDED SELECT product_id, product_name, price
FROM product
WHERE product_name = 'RedmiY2'
ORDER BY product_name;


/*
Table       :category
*/
EXPLAIN EXTENDED SELECT category_id, category_name
FROM category
WHERE category_name = 'Toys'
ORDER BY category_name;

ALTER TABLE category ADD INDEX category_name_index(category_name);

EXPLAIN EXTENDED SELECT category_id, category_name
FROM category
WHERE category_name = 'Toys'
ORDER BY category_name;