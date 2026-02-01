-- 1667. Fix Names in a Table
-- https://leetcode.com/problems/fix-names-in-a-table/

select user_id,
concat(upper(substring(name,1,1)),lower(substring(name,2))) as name from Users
order by user_id;

-- Learned substring function to extract part of string SYNTAX: substring(string, start, length)