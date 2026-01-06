-- 1211. Queries Quality and Percentage
-- https://leetcode.com/problems/queries-quality-and-percentage/description/

select query_name,round(SUM(rating/position)/count(*),2) as quality, 
round((sum(rating<3)/count(*))*100,2) as poor_query_percentage
from Queries
group by query_name;