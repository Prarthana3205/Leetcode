-- 1204. Last Person to Fit in the Bus
-- https://leetcode.com/problems/last-person-to-fit-in-the-bus/description/

with recursive QW as
(
    select turn,person_name,weight,weight as cumulative from Queue
    where turn=1
    union all
    select q.turn,q.person_name,q.weight,w.cumulative+q.weight
    from Queue q join QW w on q.turn=w.turn+1
)
select person_name from QW
where cumulative<=1000
order by cumulative desc limit 1;

-- MISTAKES INITIALLY MADE
-- incorrect join operation in recursive part of CTE