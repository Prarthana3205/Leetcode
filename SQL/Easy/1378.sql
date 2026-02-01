-- 1378. Replace Employee ID With The Unique Identifier
-- https://leetcode.com/problems/replace-employee-id-with-the-unique-identifier/description/

select u.unique_id, e.name
from Employees e
left join EmployeeUNI u
on e.id=u.id;