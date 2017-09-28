SELECT 
    CONCAT(e.first_name, ' ', e.last_name) AS all_name, l.city
FROM
    hr.departments AS d
        JOIN
    hr.employees AS e ON (d.manager_id = e.manager_id)
        JOIN
    hr.locations AS l ON (d.location_id = l.location_id)