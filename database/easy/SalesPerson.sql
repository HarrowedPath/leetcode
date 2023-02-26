select
    sp.name as name
from
    salesperson sp
where
    sp.sales_id not in (
        select o.sales_id
        from
            orders o
                left join
            company c on o.com_id = c.com_id
        where
            c.name = 'RED'
    )
;