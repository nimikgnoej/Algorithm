select distinct D.ID,D.EMAIL,D.FIRST_NAME,D.LAST_NAME
from SKILLCODES as S
join DEVELOPERS as D on S.CODE & D.SKILL_CODE
where S.CATEGORY = "Front End"
order by D.ID