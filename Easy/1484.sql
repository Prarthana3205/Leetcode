-- 1484. Group sold products by the date 
-- https://leetcode.com/problems/group-sold-products-by-the-date/

select sell_date, 
(select count(distinct product) from Activities a2 where a1.sell_date=a2.sell_date) as num_sold,
group_concat(distinct product order by product) as products
from Activities a1
group by sell_date
order by sell_date;

-- learned about group_concat function
-- group_concat([distinct] column_name order by column_name separator 'string')
-- default separator is comma (,)