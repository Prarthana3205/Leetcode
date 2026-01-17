-- 176. Second Highest Salary
-- https://leetcode.com/problems/second-highest-salary/


select coalesce(
(select salary from 
(select distinct salary, 
dense_rank() over (order by salary desc) as ranknum from Employee) temp
where ranknum=2),null) as SecondHighestSalary;

-- INITIAL SOLUTION
select coalesce(
(select salary from
(select distinct salary,
rank() over(order by salary desc) as num
from Employee) temp
where num=2),null) as SecondHighestSalary;
-- This wont work if there are duplicate highest salaries, hence using dense_rank instead of rank