-- 196. Delete Duplicate Emails
-- https://leetcode.com/problems/delete-duplicate-emails/

delete p1 from Person p1 join 
(select min(id) as min_id, email from Person group by email) p2
on p1.email=p2.email
where p1.id>p2.min_id;

-- group function to get min id for each email and then join with original table to delete rows with id greater than min id for that email
-- cannot use delete with group by directly