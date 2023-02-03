select name as Customers
from Customers c
         left join Orders o
                   on c.Id = o.customerId
where o.CustomerId is null
;