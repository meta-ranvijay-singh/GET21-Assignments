CREATE VIEW order_info AS
SELECT i.product_id, p.product_name, price, name, email, order_date, order_status 
FROM shopper s  INNER JOIN orders o 
ON o.shopper_id = s.shopper_id
INNER JOIN items i ON i.order_id = o.order_id
INNER JOIN product p ON p.product_id = i.product_id
    WHERE DATE(order_date) > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
ORDER BY order_date DESC;

SELECT * FROM order_info;

SELECT product_id, product_name, order_status
FROM order_info
WHERE order_status = "shipped";

SELECT product_id, product_name,COUNT(product_id) AS NoOfSelling
FROM order_info
GROUP BY product_id
ORDER BY NoOfSelling DESC LIMIT 5;


