-- Investment in 2016
-- https://leetcode.com/problems/investments-in-2016/desciption/

select round(sum(tiv_2016),2) as tiv_2016 from
(
    select * from Insurance i
    where tiv_2015 in (select tiv_2015 from Insurance t where i.pid!=t.pid)
) temp
where (lat,lon) not in (select lat,lon from Insurance t where temp.pid!=t.pid);

