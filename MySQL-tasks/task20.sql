SELECT d.department_name,l.city 
FROM hr.departments AS d RIGHT OUTER JOIN hr.locations AS l
ON (d.location_id = l.location_id)

