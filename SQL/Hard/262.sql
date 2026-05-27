-- 262. Trips and Users
-- https://leetcode.com/problems/trips-and-users/description

select request_at as Day,
round((sum(status='cancelled_by_driver')+sum(status='cancelled_by_client'))/count(*),2) as `Cancellation Rate` from
(select 
t.client_id, uc.banned as bannedC,
t.driver_id, ud.banned as bannedD,
t.request_at,t.status
from Trips t 
left join Users uc on t.client_id=uc.users_id
left join Users ud on t.driver_id=ud.users_id) temp
where request_at>='2013-10-01' and request_at<='2013-10-03' and (bannedC='No' and bannedD='No')
group by request_at
order by request_at;