select
    a1.activity_date as day, count(distinct a1.user_id) as active_users
from
    activity a1
where
    (a1.activity_date > "2019-06-27" AND a1.activity_date <= "2019-07-27")
group by
    a1.activity_date