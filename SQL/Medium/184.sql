-- 184. Department Highest Salary
-- Find the employee with the highest salary in each department.
--https://leetcode.com/problems/department-highest-salary/

select Department,Employee,Salary from
(
    select d.name as Department, e.name as Employee, e.salary as Salary,
    max(e.salary) over(partition by d.name order by e.salary desc) as maxs
    from Employee e left join Department d on e.departmentId=d.id
) temp
where Salary=maxs;