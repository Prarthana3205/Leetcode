-- 1789. Find the Primary Department for Each Employee
-- https://leetcode.com/problems/find-the-primary-department-for-each-employee

select employee_id,department_id from
(select employee_id,department_id,primary_flag,
count(*) over(partition by employee_id) as count
from Employee) temp
where count=1 or primary_flag='Y';