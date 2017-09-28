SELECT CONCAT(e.first_name," ",e.last_name) as employee_name,CONCAT(m.first_name," ",m.last_name) as manager_name
FROM employees AS e JOIN employees AS m
ON (e.manager_id = m.employee_id)