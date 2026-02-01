-- Q3. Monthly Transactions I
--https://leetcode.com/problems/monthly-transactions-i/description/

-- HOW TO MAKE LIFE COMPLICATED
select date_format(t.trans_date,'%Y-%m') as month,
t.country, count(*) as trans_count,
ifnull(a.approved_count,0) as approved_count,
ifnull(sum(t.amount),0) as trans_total_amount,
ifnull(a.approved_total_amount,0) as approved_total_amount
from Transactions t left join
(select date_format(trans_date,'%Y-%m') as month,
country,state,amount,count(*) as approved_count,
sum(amount) as approved_total_amount
from Transactions
where state='approved'
group by date_format(trans_date,'%Y-%m'),country) a 
on date_format(t.trans_date,'%Y-%m')=a.month and t.country<=>a.country
group by date_format(trans_date,'%Y-%m'),country;

--MUCH MUCH EASIER METHOD
select date_format(trans_date,'%Y-%m')as month,
country, count(*) as trans_count,
sum(state='approved') as approved_count,
sum(amount) as trans_total_amount,
sum(if(state='approved',amount,0)) as approved_total_amount
from Transactions
group by date_format(trans_date,'%Y-%m'),country;