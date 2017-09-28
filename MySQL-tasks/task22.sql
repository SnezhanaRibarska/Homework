Select l.city, d.department_name 
FROM hr.locations AS l,hr.departments AS d
WHERE (d.location_id = l.location_id)