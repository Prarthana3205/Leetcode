-- 180. Consequetive Numbers
-- https://leetcode.com/problems/consecutive-numbers

select distinct num as ConsecutiveNums from
(select num,
lead(num,1) over() as First,
lead(num,2) over() as Second
from Logs) temp
where num=First and First=Second;