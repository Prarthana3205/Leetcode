-- 570. Managers with at Least 5 Direct Reports
-- https://leetcode.com/problems/managers-with-at-least-5-direct-reports/description/

select name from Employee 
where id in (
    select managerID from Employee
    group by managerID
    having count(*)>=5
);