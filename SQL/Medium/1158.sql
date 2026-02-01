-- Market Analysis I
-- https://leetcode.com/problems/market-analysis-i/

select u.user_id as buyer_id,u.join_date,
sum(if(year(o.order_date)='2019',1,0)) as orders_in_2019
from Users u
left join Orders o on u.user_id=o.buyer_id 
group by u.user_id
order by u.user_id;

-- Mistakes made
-- Initially selected orders as left table therefore result did not include users with zero orders
-- Got confused with Items table which is not needed in this query