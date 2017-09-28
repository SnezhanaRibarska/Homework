SELECT CONCAT(e.first_name," ",e.last_name) AS all_name,d.department_name 
FROM hr.employees AS e JOIN hr.departments AS d
ON(e.department_id = d.department_id)
WHERE d.department_name = "Sales"