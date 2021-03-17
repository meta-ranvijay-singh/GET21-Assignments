USE storefrONt;

INSERT INTO category ( category_id, category_name) VALUES(101, "Fashion");
INSERT INTO category ( category_id, category_name) VALUES(102, "Electronics");
INSERT INTO category ( category_id, category_name) VALUES(103, "Toys");
INSERT INTO category ( category_id, category_name) VALUES(104, "Funiture");

SELECT * FROM category;

INSERT INTO subcategory (subcategory_id, subcategory_name, category_id) VALUES(1001, "Men", 101);
INSERT INTO subcategory (subcategory_id, subcategory_name, category_id) VALUES(1002, "Women", 101);
INSERT INTO subcategory (subcategory_id, subcategory_name, category_id) VALUES(1003, "Mobile", 102);
INSERT INTO subcategory (subcategory_id, subcategory_name, category_id) VALUES(1004, "Headphones", 102);
INSERT INTO subcategory (subcategory_id, subcategory_name, category_id) VALUES(1005, "Kitchen", 104);
INSERT INTO subcategory (subcategory_id, subcategory_name, category_id) VALUES(1006, "Hall", 104);
INSERT INTO subcategory (subcategory_id, subcategory_name, category_id) VALUES(1007, "Bedroom", 104);
INSERT INTO subcategory (subcategory_id, subcategory_name, category_id) VALUES(1008, "Laptop", 102);
INSERT INTO subcategory (subcategory_id, subcategory_name, category_id) VALUES(1009, "Kids", 101);
INSERT INTO subcategory (subcategory_id, subcategory_name, category_id) VALUES(1010, "Cars", 103);

SELECT * FROM subcategory;

INSERT INTO product (product_id, product_name, price, subcaategory_id) VALUES(1, "RedmiY2", 11999, 1003);
INSERT INTO product (product_id, product_name, price, subcaategory_id) VALUES(2, "Lenovo", 59999, 1008);
INSERT INTO product (product_id, product_name, price, subcaategory_id) VALUES(3, "TShirt", 1199, 1001);
INSERT INTO product (product_id, product_name, price, subcaategory_id) VALUES(4, "Jeans", 599, 1001);
INSERT INTO product (product_id, product_name, price, subcaategory_id) VALUES(5, "Denim", 890.49, 1002);
INSERT INTO product (product_id, product_name, price, subcaategory_id) VALUES(6, "Chair", 299, 1006);
INSERT INTO product (product_id, product_name, price, subcaategory_id) VALUES(7, "Power Ranger", 199, 1009);
INSERT INTO product (product_id, product_name, price, subcaategory_id) VALUES(8, "Cooker", 899.32, 1005);
INSERT INTO product (product_id, product_name, price, subcaategory_id) VALUES(9, "Boat", 499, 1004);
INSERT INTO product (product_id, product_name, price, subcaategory_id) VALUES(10, "Xiomi A10", 14999, 1003);

SELECT * FROM product;

INSERT INTO stock (product_id, available) VALUES(1, 5);
INSERT INTO stock (product_id, available) VALUES(2, 2);
INSERT INTO stock (product_id, available) VALUES(3, 6);
INSERT INTO stock (product_id, available) VALUES(4, 1);
INSERT INTO stock (product_id, available) VALUES(5, 10);
INSERT INTO stock (product_id, available) VALUES(6, 4);
INSERT INTO stock (product_id, available) VALUES(7, 3);
INSERT INTO stock (product_id, available) VALUES(8, 7);
INSERT INTO stock (product_id, available) VALUES(9, 1);
INSERT INTO stock (product_id, available) VALUES(10, 2);

SELECT * FROM stock;

INSERT INTO images (product_id, image) VALUES(1, "C:\users\ranvijay.singh_metac\Pictures\Screenshots\Screenshot (4).png");
INSERT INTO images (product_id, image) VALUES(1, "C:\users\ranvijay.singh_metac\Pictures\Screenshots\Screenshot (5).png");
INSERT INTO images (product_id, image) VALUES(2, "C:\users\ranvijay.singh_metac\Pictures\Screenshots\Screenshot (6).png");
INSERT INTO images (product_id, image) VALUES(4, "C:\users\ranvijay.singh_metac\Pictures\Screenshots\Screenshot (7).png");
INSERT INTO images (product_id, image) VALUES(6, "C:\users\ranvijay.singh_metac\Pictures\Screenshots\Screenshot (1).png");
INSERT INTO images (product_id, image) VALUES(6, "C:\users\ranvijay.singh_metac\Pictures\Screenshots\Screenshot (2).png");

SELECT * FROM images;

INSERT INTO shopper (shopper_id, name, email, address) VALUES (
    1, "Rahul", "rahul@gmail.com", "33 Walt street, Gurgaon"
);

INSERT INTO shopper (shopper_id, name, email, address) VALUES (
    2, "Rohit", "rohit@gmail.com", "sector-3, haryana"
);
INSERT INTO shopper (shopper_id, name, email, address) VALUES (
    3, "Monty", "monty@gmail.com", "42 sector, gandhi nagar"
);

SELECT * FROM shopper;

INSERT INTO shipping_address (shipping_address_id, shopper_id, shipping_address) VALUES(1, 1, "sector-45, jamunaagar");
INSERT INTO shipping_address (shipping_address_id, shopper_id, shipping_address) VALUES(2, 1, "sector-5, hanumannaagar");
INSERT INTO shipping_address (shipping_address_id, shopper_id, shipping_address) VALUES(3, 3, "3rd street, Jyoti ram");
INSERT INTO shipping_address (shipping_address_id, shopper_id, shipping_address) VALUES(4, 2, "sector-45, jamunaagar");

SELECT * FROM shipping_address;

INSERT INTO orders (order_id, order_date, order_status) VALUES (1200, '2021-02-12', "shipped");
INSERT INTO orders (order_id, order_date, order_status) VALUES (1201, '2020-09-01', "shipped");
INSERT INTO orders (order_id, order_date, order_status) VALUES (1202, '2020-12-16', "shipped");
INSERT INTO orders (order_id, order_date, order_status) VALUES (1203, '2020-11-29', "shipped");
INSERT INTO orders (order_id, order_date, order_status) VALUES (1204, '2020-10-30', "shipped");
INSERT INTO orders (order_id, order_date, order_status) VALUES (1205, '2021-03-12', "shipped");
INSERT INTO orders (order_id, order_date, order_status) VALUES (1206, '2021-02-10', "shipped");

SELECT * FROM orders;

INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 3, 1199, 2, 1200, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 4, 599, 4, 1200, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 1, 11999, 3, 1200, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 2, 59999, 1, 1202, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 5, 890.49, 5, 1202, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 7, 199, 3, 1202, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 6, 299, 2, 1202, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 2, 59999, 4, 1201, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 1, 11999, 1, 1201, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 5, 890.49, 1, 1201, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 10, 14999, 2, 1203, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 8, 899.32, 4, 1203, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 4, 599, 3, 1203, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 2, 59999, 3, 1204, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 10, 14999, 2, 1205, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 7, 199, 2, 1205, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 6, 299, 1, 1206, "paid");
INSERT INTO items (product_id, unit_price, quantity, order_id, payment) VALUES( 9, 499, 1, 1206, "paid");

SELECT * FROM items;


INSERT INTO shipped (shipping_track_id, order_id, shipping_address_id, shipping_status) 
    VALUES( 30001, 1200, 1, "Delivered");
INSERT INTO shipped (shipping_track_id, order_id, shipping_address_id, shipping_status) 
    VALUES( 30002, 1201, 4, "Delivered");
INSERT INTO shipped (shipping_track_id, order_id, shipping_address_id, shipping_status) 
    VALUES( 30003, 1202, 3, "Delivered");
INSERT INTO shipped (shipping_track_id, order_id, shipping_address_id, shipping_status) 
    VALUES( 30004, 1203, 1, "Delivered");
INSERT INTO shipped (shipping_track_id, order_id, shipping_address_id, shipping_status) 
    VALUES( 30005, 1204, 2, "OutForDelivery");
INSERT INTO shipped (shipping_track_id, order_id, shipping_address_id, shipping_status) 
    VALUES( 30006, 1205, 3, "Delivered");
INSERT INTO shipped (shipping_track_id, order_id, shipping_address_id, shipping_status) 
    VALUES( 30007, 1206, 4, "OutForDelivery");
    
SELECT * FROM shipped;

/* 
Display Id, Title, Category Title, Price of the products which are Active and recently added
products should be at top.
*/
SELECT product.product_id, product_name, category_name, price
FROM product,category,subcategory,stock
WHERE product.subcategory_id = subcategory.subcategory_id 
    AND subcategory.category_id = category.category_id
    AND product.product_id = stock.product_id
    AND stock.available > 0
ORDER BY product_id DESC;
/* using join*/
SELECT p.product_id, product_name, c.category_name, price
FROM product p INNER JOIN subcategory sc ON p.subcategory_id = sc.subcategory_id
 INNER JOIN category c ON sc.category_id = c.category_id
 INNER JOIN stock s ON p.product_id = s.product_id
WHERE s.available > 0
ORDER BY p.product_id DESC;

/* Display the list of products which dON't have any images. */
SELECT * FROM product p
    WHERE p.product_id not in(SELECT i.product_id FROM images i);

/* 
Display all Id, Title AND Parent Category Title for all the Categories listed, 
sorted by Parent Category Title and then Category Title. (If Category is top category 
then Parent Category Title column should display “Top Category” as value.)
*/
SELECT p.product_id, p.product_name, c.category_name
    FROM product p INNER JOIN subcategory sc ON p.subcategory_id = sc.subcategory_id
    INNER JOIN category c ON c.category_id = sc.category_id
    ORDER BY c.category_id, sc.subcategory_id ASC;
    
/*
Display Id, Title, Parent Category Title of all the leaf Categories 
(categories which are not parent of any other category)
*/
SELECT sc.subcategory_id, subcategory_name, c.category_name as parent_category
    FROM subcategory sc INNER JOIN category c ON sc.category_id = c.category_id;
    
/*
Display Product Title, Price & DESCriptiON which falls into particular category Title
(i.e. “Mobile”)
*/
SELECT p.product_name, price FROM product p
    WHERE p.subcategory_id in 
    (SELECT sc.subcategory_id FROM subcategory sc WHERE sc.subcategory_name="Mobile");

/*
Display the list of Products whose Quantity ON hand (Inventory) is under 50.
*/
SELECT p.product_id, p.product_name, price, subcategory_id, available FROM product p INNER JOIN stock s ON s.product_id=p.product_id
    WHERE s.available < 50;

