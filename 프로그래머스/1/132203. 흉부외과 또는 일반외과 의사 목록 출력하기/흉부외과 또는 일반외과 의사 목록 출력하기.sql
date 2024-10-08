select dr_name,dr_id,mcdp_cd,DATE_FORMAT(doctor.hire_ymd, "%Y-%m-%d")
from doctor
where mcdp_cd = "CS" OR mcdp_cd = "GS"
order by hire_ymd desc, dr_name asc