-- 3482. Analyze Organization Hierarchy
-- https://leetcode.com/problems/analyze-organization-hierarchy/

with recursive hierarchy as
(
    select employee_id,employee_name,manager_id,salary,
    1 as level
    from Employees
    where manager_id is NULL

union all

    select e.employee_id,e.employee_name,e.manager_id,e.salary,
    h.level+1
    from Employees e join hierarchy h on e.manager_id=h.employee_id -- descending down
),depth as
(
    select employee_id,employee_name,manager_id,salary,
    1 as team_size
    from Employees 
    where manager_id is not NULL

union all

    select e.employee_id,e.employee_name,e.manager_id,d.salary,
    1 as team_size
    from Employees e join depth d on e.employee_id=d.manager_id -- going up
),team as
(
    select manager_id as employee_id, sum(team_size) as team_size,
    sum(salary) as budget
    from depth 
    group by manager_id
)
select h.employee_id,h.employee_name,h.level,
ifnull(t.team_size,0) as team_size,
ifnull(t.budget,0)+h.salary as budget
from hierarchy h left join team t on h.employee_id=t.employee_id
order by h.level,budget desc,h.employee_name;