-- 1907. Category of Each Employee Based on Salary
-- https://leetcode.com/problems/category-of-each-employee-based-on-salary/description/

(select 'Low Salary' as category,sum(LowSal) as accounts_count from (select
case when income<20000 then 1 else 0 
end as LowSal from Accounts) temp)
union all
(select 'Average Salary' as category,sum(AvgSal) as accounts_count from (select
case when income>=20000 and income<=50000 then 1 else 0 end as AvgSal from Accounts) temp2)
union all
(select 'High Salary' as category,sum(HighSal) as accounts_count from (select
case when income>50000 then 1 else 0 end as HighSal from Accounts) temp3);
