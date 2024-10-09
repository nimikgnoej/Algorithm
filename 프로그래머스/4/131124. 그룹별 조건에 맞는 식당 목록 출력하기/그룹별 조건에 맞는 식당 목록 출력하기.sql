select M.MEMBER_NAME,R.REVIEW_TEXT,DATE_FORMAT(R.REVIEW_DATE,"%Y-%m-%d") as REVIEW_DATE
from MEMBER_PROFILE as M
join REST_REVIEW as R on M.MEMBER_ID = R.MEMBER_ID
where M.MEMBER_ID = (select MEMBER_ID
                        from REST_REVIEW
                        group by MEMBER_ID
                        order by count(MEMBER_ID) desc
                        limit 1)
order by REVIEW_DATE , REVIEW_TEXT

