-- 1164. Product Price at a Given Date
-- https://leetcode.com/problems/product-price-at-a-given-date/

-- date must be enclosed in single quotes else it will be treated as a math expression

select product_id,price from
(
    select product_id,
    case when mindate>'2019-08-16' then 10 -- if the minimum date for that product_id is greater than the given date, then price is 10
    else new_price end as price,
    change_date,
    max(change_date) over(partition by product_id) as maxf from -- again this max date per product_id to be used in outer query
    (
        select product_id,new_price,change_date,
        min(change_date) over(partition by product_id) as mindate, -- inner most query I found the min and max date per product_id
        max(change_date) over(partition by product_id) as maxdate -- to be used in outer queries
        from Products
    ) temp
    where change_date<='2019-08-16' or mindate>'2019-08-16'
) temp2
where change_date=maxf;