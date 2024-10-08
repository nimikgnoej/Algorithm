select I.rest_id,I.rest_name,I.food_type,I.favorites,I.address,round(avg(R.review_score),2) as score
from rest_info as I
join rest_review as R on I.rest_id = R.rest_id
group by R.rest_id
having address like "서울%"
order by score desc, favorites desc