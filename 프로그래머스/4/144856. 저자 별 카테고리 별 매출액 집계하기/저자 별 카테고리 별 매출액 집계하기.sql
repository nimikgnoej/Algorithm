select A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, sum(S.SALES*B.PRICE) as TOTAL_SALES
from BOOK_SALES as S
join BOOK as B on B.BOOK_ID = S.BOOK_ID
join AUTHOR as A on A.AUTHOR_ID = B.AUTHOR_ID
where Year(S.SALES_DATE)='2022' and Month(S.SALES_DATE)='1'
group by A.AUTHOR_ID, B.CATEGORY
order by A.AUTHOR_ID asc, B.CATEGORY desc

# select *, sum(sales)
# from BOOK_SALES
# where Year(SALES_DATE)='2022' and Month(SALES_DATE)='1'
# group by book_id
# order by book_id