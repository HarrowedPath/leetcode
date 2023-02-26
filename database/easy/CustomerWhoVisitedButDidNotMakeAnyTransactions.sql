select
    v1.customer_id, count(v1.customer_id) as count_no_trans
    from
        visits v1
    where
        v1.visit_id not in (
            select v2.visit_id
                from visits v2
                    join
                transactions t on t.visit_id = v2.visit_id
        )
    group by customer_id
;