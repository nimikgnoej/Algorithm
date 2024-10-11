# select Year(O.SALES_DATE) as YEAR,
#         Month(O.SALES_DATE) as MONTH,
#         count(distinct U.USER_ID) as PURCHASED_USERS,
#         round(count(distinct U.USER_ID) / 
#               (select count(*) from USER_INFO where Year(U.JOINED) = "2021"),1)
#               as PURCHASED_RATIO
# from USER_INFO as U
# join ONLINE_SALE as O on U.USER_ID = O.USER_ID
# where Year(U.JOINED) = "2021"
# group by YEAR,MONTH
# order by YEAR,MONTH

SELECT   YEAR(A.SALES_DATE) AS YEAR
                 , MONTH(A.SALES_DATE) AS MONTH
                 , COUNT(DISTINCT(B.USER_ID)) AS PUCHASED_USERS
                 , ROUND(COUNT(DISTINCT B.USER_ID)/(SELECT COUNT(USER_ID) FROM USER_INFO WHERE YEAR(JOINED)='2021'), 1) AS PURCHASED_RATIO
   FROM   ONLINE_SALE AS A
     LEFT
     JOIN   USER_INFO AS B
        ON   A.USER_ID = B.USER_ID
WHERE  YEAR(B.JOINED) = '2021'
GROUP
         BY  YEAR(A.SALES_DATE)
                , MONTH(A.SALES_DATE)
ORDER
        BY  YEAR ASC
               , MONTH ASC