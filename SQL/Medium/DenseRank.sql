-- Rank Scores without using dense_rank()
-- https://leetcode.com/problems/rank-scores/

-- Leetcode does not accept dense_rank()
select s1.score,
(select count(distinct s2.score) from Scores s2
where s2.score>=s1.score) as `rank` 
from Scores s1
order by s1.score desc;
-- backticks for rank else mysql mistakes it for a keyword
-- count the number of distinct scores above it that will give the rank