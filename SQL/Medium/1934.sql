-- 1934. Confirmation Rate for Each Employee
-- https://leetcode.com/problems/confirmation-rate

select s.user_id,round(ifnull(sum(c.action='confirmed')/count(*),0),2) as confirmation_rate
from Signups s left join Confirmations c on s.user_id=c.user_id
group by user_id;