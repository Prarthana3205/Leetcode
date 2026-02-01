-- 619. Biggest Single Number
-- https://leetcode.com/problems/biggest-single-number/

select coalesce(
(select num from MyNumbers 
group by num
having count(*)=1
order by num desc limit 1),null) as num;

-- COALESCE(expr1, expr2, expr3, ...)
-- The COALESCE() function returns the first non-null expression among its arguments.