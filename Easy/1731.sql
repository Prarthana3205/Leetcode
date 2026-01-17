-- 1731. The Number of Employees which report to Each Employee
-- https://leetcode.com/problems/the-number-of-employees-which-report-to-each-employee

select employee_id,name,
(select count(*) from Employees e2 where e.employee_id=e2.reports_to) as reports_count,
(select round(avg(age)) from Employees e3 where e.employee_id=e3.reports_to) as average_age
from Employees e
where employee_id in(select reports_to from Employees)
order by employee_id;

-- ALTERNATIVE SOLUTION
select e.employee_id,e.name,e2.reports_count,e2.average_age
from Employees e join 
(
    select reports_to,count(*) as reports_count,
    round(avg(age)) as average_age
    from Employees
    group by reports_to
) e2
on e.employee_id=e2.reports_to
order by employee_id;