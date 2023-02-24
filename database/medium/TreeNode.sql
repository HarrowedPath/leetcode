select id as Id,
    case
        when t1.id = (select t2.id from tree t2 where t2.p_id is null)
            then 'Root'
        when t1.id in (select t2.p_id from tree t2)
            then 'Inner'
        else 'Leaf'
    end as type
    from tree t1
order by id
