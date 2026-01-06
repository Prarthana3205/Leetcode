-- 1581. Customer Who Visited but Did Not Make Any Transactions
-- https://leetcode.com/problems/customer-who-visited-but-did-not-make-any-transactions/description/

select v.customer_id,count(*) as count_no_trans
from Visits v
left join Transactions t
on v.visit_id=t.visit_id
where transaction_id is NULL
group by customer_id;