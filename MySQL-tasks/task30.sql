SELECT 
    CONCAT(e.first_name, ' ', e.last_name) AS all_name,
    j.job_title,
    d.department_name,
    l.city,
    c.country_name,
    r.region_name,
    CONCAT(m.first_name, ' ', m.last_name) AS manager_name
FROM
    hr.employees AS e
        JOIN
    hr.jobs AS j ON (e.job_id = j.job_id)
        JOIN
    hr.departments AS d ON (e.department_id = d.department_id)
        JOIN
    hr.locations AS l ON (d.location_id = l.location_id)
        JOIN
    hr.countries AS c ON (l.country_id = c.country_id)
        JOIN
    hr.regions AS r ON (c.region_id = r.region_id)
        JOIN
    hr.employees AS m ON (e.manager_id = m.employee_id)