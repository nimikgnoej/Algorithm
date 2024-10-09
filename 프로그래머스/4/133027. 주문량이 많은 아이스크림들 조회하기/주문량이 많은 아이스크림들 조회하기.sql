select J.FLAVOR
from FIRST_HALF as F
join JULY as J on F.FLAVOR = J.FLAVOR
group by J.FLAVOR
order by (F.TOTAL_ORDER+sum(J.TOTAL_ORDER)) desc
limit 3

# select * from july