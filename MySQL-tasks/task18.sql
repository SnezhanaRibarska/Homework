SELECT department_name,city FROM hr.departments AS d INNER JOIN hr.locations AS l ON(d.location_id = l.location_id)
