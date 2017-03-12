select em.Name as Employee
from Employee em left join Employee ma on em.ManagerId = ma.Id
where em.Salary > ma.Salary