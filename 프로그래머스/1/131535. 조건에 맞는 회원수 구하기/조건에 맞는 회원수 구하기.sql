select count(*)
from user_info
where joined>="2021-01-01" and joined <= "2021-12-31"
and age>=20 and age<=29