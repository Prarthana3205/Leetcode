-- Nth Highest Salary
-- https://leetcode.com/problems/nth-highest-salary/

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
    select coalesce(
    (select salary from
      (select id, salary,
      dense_rank() over(order by salary desc) as rankrow
      from Employee) temp
    where rankrow=n limit 1),null)
  );
END