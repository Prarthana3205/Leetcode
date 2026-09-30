-- 185. Department Top Three Salaries
-- https://leetcode.com/problems/department-top-three-salaries/

select Department,Employee,Salary from
(
    select d.name as Department,e.name as Employee,e.salary as Salary,
    dense_rank() over(partition by d.name order by e.salary desc) as ranknum from Employee e 
    join Department d on e.departmentId=d.id
) temp
where ranknum<=3;