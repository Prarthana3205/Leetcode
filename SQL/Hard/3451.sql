-- 3451. Find Invalid IP Addresses
-- https://leetcode.com/problems/find-invalid-ip-addresses/description/

-- within the not condition check dont get confused with AND OR

select ip,count(*) as invalid_count
from logs
where
length(ip)-length(replace(ip,'.',''))!=3
OR NOT
(
    cast(substring_index(ip,'.',1)as unsigned) <=255 AND
    cast(substring_index(substring_index(ip,'.',2),'.',-1) as unsigned) <=255 AND
    cast(substring_index(substring_index(ip,'.',3),'.',-1) as unsigned) <=255 AND
    cast(substring_index(ip,'.',-1) as unsigned) <=255
)
OR
(
    substring_index(ip,'.',1) like '0%' AND length(substring_index(ip,'.',1))>1 OR
    substring_index(substring_index(ip,'.',2),'.',-1) like '0%' AND length(substring_index(substring_index(ip,'.',2),'.',-1))>1 OR
    substring_index(substring_index(ip,'.',3),'.',-1) like '0%' AND length(substring_index(substring_index(ip,'.',3),'.',-1))>1 OR
    substring_index(ip,'.',-1) like'0%' AND length(substring_index(ip,'.',-1))>1
)
group by ip
order by invalid_count desc,ip desc;