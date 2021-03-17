/*
Display Recent 50 Orders placed (Id, Order Date, Order Total).
*/
SELECT o.order_id, order_date, SUM(unit_price*quantity) as total
    FROM orders o, items i
    WHERE o.order_id = i.order_id
    GROUP BY i.order_id
    ORDER BY order_date DESC LIMIT 50;

/*
Display 10 most expensive Orders.
*/
SELECT o.order_id, order_date, SUM(unit_price*quantity) as total
    FROM orders o, items i
    WHERE o.order_id = i.order_id
    GROUP BY i.order_id
    ORDER BY total DESC LIMIT 10;
    
/*
Display all the Orders which are placed more than 10 days old and one or more items 
FROM those orders are still not shipped.
*/
SELECT * FROM orders
WHERE DATE(order_date) < DATE_SUB(CURDATE(), INTERVAL 10 DAY)
    AND order_status != "not shipped";

/*
Display list of shoppers which haven't ordered anything since last month.
*/
SELECT DISTINCT(s.shopper_id),name,address FROM shopper s 
INNER JOIN orders o ON o.shopper_id = s.shopper_id
    WHERE s.shopper_id NOT IN 
    (SELECT shopper_id FROM orders
        WHERE DATE(order_date) > DATE_SUB(CURDATE(), INTERVAL 30 DAY)
    );
    
/*
Display list of shopper along with orders placed by them in last 15 days. 
*/
SELECT DISTINCT(s.shopper_id),name,o.order_id,order_date FROM shopper s 
INNER JOIN orders o ON o.shopper_id = s.shopper_id
    WHERE DATE(order_date) > DATE_SUB(CURDATE(), INTERVAL 15 DAY);
    
/*
Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
*/
SELECT product_id, unit_price, quantity, i.order_id, payment, order_status
FROM items i INNER JOIN orders o ON o.order_id=i.order_id
WHERE o.order_status != "not shipped";

/*
Display list of order items along with order placed date which fall between Rs 200 to Rs 500 price.
*/
SELECT product_id, unit_price, quantity, i.order_id, payment, order_date
FROM items i INNER JOIN orders o ON o.order_id=i.order_id
WHERE unit_price BETWEEN 200 AND 500;