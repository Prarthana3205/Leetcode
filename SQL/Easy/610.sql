-- 610. Triangle Judgement
-- https://leetcode.com/problems/triangle-judgement

select x,y,z,
case when x+y>z and y+z>x and z+x>y then 'Yes'
else 'No'
end as triangle
from Triangle;

-- You just have to know the theorem that the sum of lengths of any two sides of a triangle is greater than the length of the third side.