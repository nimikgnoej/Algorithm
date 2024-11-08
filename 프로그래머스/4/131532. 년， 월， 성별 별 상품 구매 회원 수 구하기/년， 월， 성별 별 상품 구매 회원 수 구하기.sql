select Year(O.SALES_DATE) as YEAR, Month(O.SALES_DATE) as MONTH, U.GENDER, count(distinct U.USER_ID) as USERS
from USER_INFO as U
join ONLINE_SALE as O on U.USER_ID = O.USER_ID
where U.GENDER is not null
group by Year(O.SALES_DATE), Month(O.SALES_DATE), U.GENDER
order by Year(O.SALES_DATE) asc , Month(O.SALES_DATE) asc , U.GENDER asc