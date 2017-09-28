SELECT distinct d.department_name , CONCAT(e.first_name,"  ", e.last_name) AS all_name
FROM hr.departments AS d LEFT OUTER JOIN hr.employees AS e
ON (d.manager_id = e.manager_id)