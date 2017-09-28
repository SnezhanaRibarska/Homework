SELECT department_name AS all_names FROM hr.departments
UNION 
SELECT region_name FROM hr.regions
UNION 
SELECT country_name FROM hr.countries
UNION 
SELECT city FROM hr.locations 

