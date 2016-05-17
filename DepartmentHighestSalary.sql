select Department.Name, s1.Name, s1.Salary
from Employee s1 join (
    select DepartmentId, max(Salary) as Salary
    from Employee 
    group by (DepartmentId)) s2 on s1.DepartmentId = s2.DepartmentId
    join Department on s1.DepartmentId = Department.Id
where s1.Salary = s2.Salary