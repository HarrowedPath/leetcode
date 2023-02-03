select e.name as 'Employee', e.salary, d.name as 'Department'
from Employee e
         join Department d
              on d.id = e.departmentId
where 3 > (select count(distinct e1.salary)
           from Employee e1
           where e1.salary > e.salary
             and e.departmentId = e1.departmentId)
;