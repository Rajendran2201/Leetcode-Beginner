SELECT e1.name as Employee
FROM Employee e1
WHERE e1.salary > (select e2.salary from Employee e2 where e1.managerId = e2.id);