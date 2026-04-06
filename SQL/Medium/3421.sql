-- 3421. 
-- https://leetcode.com/problems/find-students-who-improved/description/

-- Mistakes made
-- First used subqueries and completely forgot about about self join

with ranking as 
(
    select*,
    row_number() over(partition by student_id,subject order by exam_date) as First,
    row_number() over(partition by student_id,subject order by exam_date desc) as Last,
    count(exam_date) over(partition by student_id,subject) as count
    from Scores
)
select r1.student_id,r1.subject,r1.score as first_score,r2.score as latest_score
from ranking r1
join ranking r2 on r1.student_id=r2.student_id and r1.subject=r2.subject
where r1.count>1 and r1.First=1 and r2.Last=1 and r2.score>r1.score;