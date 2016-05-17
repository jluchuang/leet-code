select 
    d.Name as Department,e.Name as Employee, e.Salary  
from   
    (
    select
            e1.Name, e1.Salary,e1.DepartmentId
        from Employee e1
        inner join Employee e2
            on  e1.DepartmentId = e2.DepartmentId 
                and e1.Salary <= e2.Salary
        group by e1.Id
        having count(distinct e2.Salary) <=3
    ) e
inner join Department d
    on e.DepartmentId = d.Id
