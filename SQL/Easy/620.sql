-- 620. Not Boring Movies
-- https://leetcode.com/problems/not-boring-movies/description/

select* from Cinema except all
(select * from Cinema
where id%2=0 or description='boring')
order by rating desc;