SELECT department_name,city,CONCAT(first_name," - " ,last_name) AS all_name FROM hr.departments AS d INNER JOIN hr.locations 
AS l ON(d.location_id = l.location_id) INNER JOIN hr.employees AS e ON(d.manager_id = e.manager_id)
