/*
Create a Stored procedure to retrieve average sales of each product in a month. 
Month and year will be input parameter to function.
*/
DELIMITER $
CREATE PROCEDURE averageSales(Month int, Year int)
BEGIN
DECLARE totalSale INT;
SET totalSale = findSalePerMonth(Month, Year);

SELECT *, SUM(quantity*unit_price)/day(last_day( CONCAT(Year,'-',Month,'-01') )) AS avg_sale
FROM items i INNER JOIN orders o 
ON o.order_id = i.order_id
WHERE month(o.order_date)=Month AND year(o.order_date)=Year
GROUP BY product_id;

END$
DELIMITER ;

DELIMITER $
CREATE FUNCTION findSalePerMonth(Month int, Year int)

RETURNS INT
BEGIN

DECLARE sales INT;

SET sales = 0;

SELECT SUM(quantity) INTO sales
FROM items i INNER JOIN orders o 
ON o.order_id = i.order_id
WHERE month(o.order_date)=Month AND year(o.order_date)=Year;

RETURN sales;

END$
DELIMITER ;

CALL averageSales(2,2021);

/*
Create a stored procedure to retrieve table having order detail with status for a given period.
Start date and end date will be input parameter. Put validation on input dates like 
start date is less than end date. If start date is greater than end date take first date 
of month as start date.
*/
DELIMITER $
CREATE PROCEDURE orderDetails(startDate date, endDate date)
BEGIN

IF startDate > endDate 
    THEN SET startDate =  DATE_FORMAT(startDate, '%Y-%m-01');
END IF;

SELECT * from orders
    WHERE order_date BETWEEN startDate AND endDate;

END$
DELIMITER ;

CALL orderDetails('2021-03-30', '2021-03-19');