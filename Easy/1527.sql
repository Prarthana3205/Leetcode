-- 1527. Patients With a Condition
-- https://leetcode.com/problems/patients-with-a-condition/

select * from Patients 
where conditions regexp '(^| )DIAB1';

-- difference between like and regexp
-- like is used for simple pattern matching with % and _ wildcards
-- regexp is used for more complex pattern matching using regular expressions