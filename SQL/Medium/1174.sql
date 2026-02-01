-- 1174. Immediate Food Delivery II
-- https://leetcode.com/problems/immediate-food-delivery-ii/description/

select round((sum(first_order_date=customer_pref_delivery_date)*100)/count(*),2) as immediate_percentage from
(select immediate as first_order_date,customer_pref_delivery_date from
(select order_date,customer_pref_delivery_date,
min(order_date) over(partition by customer_id) as immediate
from Delivery) temp
where order_date=immediate) temp2;


-- Alternative Solution without 2nd subquery
select round((sum(order_date=customer_pref_delivery_date)*100)/count(*),2) as immediate_percentage from
(select order_date,customer_pref_delivery_date,
min(order_date) over(partition by customer_id) as immediate
from Delivery) temp
where order_date=immediate;