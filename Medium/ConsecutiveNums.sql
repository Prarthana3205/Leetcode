-- Find all numbers that appear at least three times consecutively in the Logs table.
-- https://leetcode.com/problems/consecutive-numbers

select distinct num as ConsecutiveNums from
(select num,
lead(num,1) over() as First,
lead(num,2) over() as Second
from Logs) temp
where num=First and First=Second;