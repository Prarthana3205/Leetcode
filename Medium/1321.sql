-- 1321. Restaurant Growth
-- https://leetcode.com/problems/restaurant-growth/

select distinct 
date_add(visited_on, interval 6 day) as visited_on,
movingamount as amount,
round(movingamount/7,2) as average_amount from
(
    select customer_id,name,visited_on,amount,
    (select sum(amount) from Customer c2 
    where c2.visited_on>=c1.visited_on and c2.visited_on<=date_add(c1.visited_on,interval 6 day)) as movingamount,
    (select count(distinct visited_on) from Customer c2 
    where c2.visited_on>=c1.visited_on and c2.visited_on<=date_add(c1.visited_on,interval 6 day)) as movcount
    from Customer c1
) temp
where movcount=7;