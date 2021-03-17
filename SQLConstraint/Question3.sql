/*
Display Shopper’s information along with number of orders he/she placed during last 30 days.
*/
SELECT s.shopper_id, name, email,
COUNT(DISTINCT CASE WHEN DATE(order_date) > DATE_SUB(CURDATE(), INTERVAL 30 DAY)
THEN order_date END) AS NoOfOrdersInLastMonth
FROM shopper s INNER JOIN orders o 
ON o.shopper_id = s.shopper_id
GROUP BY o.shopper_id;

/*
Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
*/
SELECT s.shopper_id, s.name, email, SUM(unit_price*quantity) as total
    FROM shopper s, orders o, items i
    WHERE o.order_id = i.order_id 
        AND s.shopper_id = o.shopper_id
        AND DATE(order_date) > DATE_SUB(CURDATE(), INTERVAL 30 DAY)
    GROUP BY o.shopper_id
    ORDER BY total DESC LIMIT 10;
    
/*
Display top 20 Products which are ordered most in last 60 days along with numbers.
*/
SELECT p.product_id, p.product_name, price, SUM(i.quantity) as NoOfOrder
    FROM product p, items i, orders o 
    WHERE i.product_id = p.product_id
        AND o.order_id = i.order_id
        AND DATE(order_date) > DATE_SUB(CURDATE(), INTERVAL 60 DAY)
    GROUP BY i.product_id
    ORDER BY NoOfOrder DESC LIMIT 20;
    
/*
Display Monthly sales revenue of the StoreFront for last 6 months. 
It should display each month’s sale.
*/
    SELECT year(o.order_date),month(o.order_date), SUM(unit_price*quantity) as revenue
    FROM shopper s, orders o, items i
    WHERE o.order_id = i.order_id 
    GROUP BY o.shopper_id, year(o.order_date),month(o.order_date)
    ORDER BY year(o.order_date),month(o.order_date) LIMIT 6;
    
/*
Given a category search keyword, display all the Products present in this category/categories.
*/

SELECT p.product_id, p.product_name, price
FROM product p INNER JOIN subcategory sc 
ON sc.subcategory_id = p.subcategory_id
INNER JOIN category c ON c.category_id = sc.category_id
WHERE c.category_name="Fashion";