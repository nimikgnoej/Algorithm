select A.ID,B.FISH_NAME,A.LENGTH as LENGTH
from FISH_INFO A
join FISH_NAME_INFO B on A.FISH_TYPE = B.FISH_TYPE
where B.FISH_TYPE 
in (select FISH_TYPE 
    from FISH_INFO 
    group by FISH_TYPE
    having LENGTH = max(LENGTH))
    