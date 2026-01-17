-- 602. Friend Requests II:Who Has the Most Friends
-- https://leetcode.com/problems/friend-requests-ii-who-has-the-most-friends/

select requester_id as id, num1+num2 as num from
(select distinct requester_id,
(select count(distinct accepter_id) from RequestAccepted ra2 where ra1.requester_id=ra2.requester_id) as num1,
(select count(distinct requester_id) from RequestAccepted ra3 where ra1.requester_id=ra3.accepter_id) as num2
from RequestAccepted ra1
union 
select distinct accepter_id,
(select count(distinct requester_id) from RequestAccepted ra4 where ra1.accepter_id=ra4.accepter_id) as num1,
(select count(distinct accepter_id) from RequestAccepted ra5 where ra1.accepter_id=ra5.requester_id) as num2
from RequestAccepted ra1) temp
order by num desc limit 1;

-- Initially mistake made was forgot to consider acceptor_id as well under id column
-- So had to do union of two subqueries to get total friends for each user