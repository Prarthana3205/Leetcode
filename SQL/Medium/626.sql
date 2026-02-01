-- 626. Exchange Seats  
-- https://leetcode.com/problems/exchange-seats/


select id,
case when studentnew is null then student
else studentnew
end as student from
(select id,student,
case when id%2=1 then lead(student) over()
else lag(student) over()
end as studentnew
from Seat) temp;

-- Alternative Solution
select id,
case when id%2=1 then ifnull(lead(student) over(),student)
else lag(student) over()
end as student
from Seat;