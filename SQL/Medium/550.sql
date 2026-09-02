-- Game Play Analysis
-- https://leetcode.com/problems/game-play-analysis-iv/description/

select ifnull(round(sum(next_day=checking)/count(distinct player_id),2),0) as fraction from
(
    select player_id,event_date, date_add(event_date,interval 1 day) as next_day,
    lead(event_date,1) over (partition by player_id order by event_date) as checking
    from Activity
) temp
where event_date in
(
    select min(event_date) from Activity a
    where a.player_id=temp.player_id
);

-- MISTAKES MADE:
-- date_add to add to any date instead of simply adding 1 to date, adding 1 converts to string and then adds 1
-- where condition to filter only first event_date per player_id else will result in counting all duplicate event_dates
