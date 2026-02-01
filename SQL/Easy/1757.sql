-- 1757. Products With Low Fat and Recyclable
-- https://leetcode.com/problems/products-with-low-fat-and-recyclable/description/

select product_id 
from Products 
where low_fats='Y' and recyclable='Y';
