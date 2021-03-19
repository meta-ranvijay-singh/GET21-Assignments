/*
Create a function to calculate number of orders in a month. Month and year will 
be input parameter to function.
*/

DELIMITER $
CREATE FUNCTION calculateNumberOfOrder(Month int, Year int)

RETURNS INT
BEGIN

DECLARE no_of_order INT;

SET no_of_order = 0;

SELECT COUNT(month(order_date)) INTO no_of_order
    FROM orders
    WHERE year(order_date) = Year AND month(order_date) = Month
    GROUP BY month(order_date);

RETURN no_of_order;

END$
DELIMITER ;
    
SELECT calculateNumberOfOrder(2,2021) AS numberOfOrders;

/*
Create a function to return month in a year having maximum orders. Year will be input parameter.
*/

DELIMITER $
CREATE FUNCTION findMaxOrdersMonth(Year int)

RETURNS INT
BEGIN

DECLARE month INT;

SET month = 0;

SELECT month(order_date) INTO month
    FROM orders
    WHERE year(order_date) = Year
    GROUP BY month(order_date)
    ORDER BY COUNT(month(order_date)) DESC LIMIT 1;

RETURN month;

END$
DELIMITER ;

SELECT findMaxOrdersMonth(2021) AS month;