-- 1517. Find Users With Valid E-Mails
-- https://leetcode.com/problems/find-users-with-valid-e-mails/

select * from Users 
where mail regexp '^[A-Za-z][A-Za-z0-9_.-]*@leetcode\\.com$'
and mail like binary '%@leetcode\\.com';

-- in regex no pipes needed for OR condition, ordering matters 
-- in @leetcode.com, the dot operator indicates any character so we need to escape it with backslash
-- default regexp is case insensitive therefore we use binary to make it case sensitive