Select l.city, d.department_name 
FROM hr.locations AS l LEFT OUTER JOIN hr.departments AS d
ON (d.location_id = l.location_id)