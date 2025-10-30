select id as Id from(
select id, temperature,recordDate,
lag(temperature) over (order by recordDate) as prev,
lag(recordDate) over(order by recordDate) as prev_date
from Weather) as diff
where temperature-prev>0 and 
datediff(recordDate,prev_date)=1;