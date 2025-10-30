select* from Cinema except all
(select * from Cinema
where id%2=0 or description='boring')
order by rating desc;