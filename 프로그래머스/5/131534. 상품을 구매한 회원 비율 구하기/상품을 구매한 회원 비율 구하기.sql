select Year(O.SALES_DATE) as YEAR,
        Month(O.SALES_DATE) as MONTH,
        count(distinct U.USER_ID) as PURCHASED_USERS,
        round(count(distinct U.USER_ID) / 
              (select count(USER_ID) from USER_INFO where Year(JOINED) = "2021"),1)
              as PURCHASED_RATIO
from ONLINE_SALE as O
join USER_INFO as U on U.USER_ID = O.USER_ID
where Year(U.JOINED) = "2021"
group by Year(O.SALES_DATE),Month(O.SALES_DATE)
order by Year(O.SALES_DATE),Month(O.SALES_DATE)