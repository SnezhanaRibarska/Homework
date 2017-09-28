SELECT CONCAT(e.first_name," ",e.last_name),d.department_name,e.hire_date 
FROM hr.employees AS e LEFT JOIN hr.departments AS d
ON(e.department_id = d.department_id)
WHERE d.department_name LIKE "Sales" OR "Finance" AND hire_date IN (1995,2000) 
