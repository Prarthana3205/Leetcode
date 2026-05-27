-- 601. Human Traffic of Stadium
-- https://leetcode.com/problems/human-traffic-of-stadium

select id,visit_date,people from
(select id,visit_date,people,
(select count(id) from 
(select id from Stadium where people>=100) s2 where s2.id<=s1.id) as rownum
from (select * from Stadium where people>=100) s1
) temp
where id-rownum in
(
select id-rownum from
(select id,
(select count(id) from 
(select id from Stadium where people>=100) s2 where s2.id<=s1.id) as rownum
from (select * from Stadium where people>=100) s1) temp2
group by id-rownum
having count(*)>2
)
order by visit_date;