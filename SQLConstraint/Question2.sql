/*
Display the Categories along with number of products under each category.
*/
SELECT c.category_id, c.category_name, COUNT(p.subcategory_id) AS NumberOfProduct
FROM subcategory sc INNER JOIN product p
ON p.subcategory_id = sc.subcategory_id
INNER JOIN category c ON c.category_id=sc.category_id
GROUP BY c.category_id;

/*
Display the list of products (Id, Title, Count of Categories) which fall in more than 
one Categories.
*/
SELECT p.product_id, p.product_name
FROM product p INNER JOIN subcategory sc
ON p.subcategory_id = sc.subcategory_id
INNER JOIN category c ON c.category_id=sc.category_id;

/*
Display Count of products as per below price range:
*/
SELECT 
COUNT(DISTINCT CASE WHEN price >= 0 AND price <= 100 THEN product_id END) AS `0-100`,
COUNT(DISTINCT CASE WHEN price >= 101 AND price <= 500 THEN product_id END) AS `101-500`,
COUNT(DISTINCT CASE WHEN price > 500 THEN product_id END) AS `Above 500`
FROM product