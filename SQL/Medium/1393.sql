-- 1393. Capital GainLoss
-- https://leetcode.com/problems/capital-gainloss/description/

select stock_name, total_sell-total_buy as capital_gain_loss from
(
    select stock_name,
    sum(case when operation="Buy" then price else 0 end) as total_buy,
    sum(case when operation="Sell" then price else 0 end) as total_sell 
    from Stocks
    group by stock_name
) as temp;