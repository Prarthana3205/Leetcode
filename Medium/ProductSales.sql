-- Find the first year sales for each product along with quantity and price.
-- https://leetcode.com/problems/product-sales-analysis-iii

select product_id,first_year,quantity,price from
(select sale_id,product_id,year,quantity,price,
min(year) over(partition by product_id) as first_year from Sales) temp
where year=first_year;