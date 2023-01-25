cnt = 0
n,l = map(int,input().split())
pool = [list(map(int,input().split())) for _ in range(n)]
pool.sort(key=lambda x:x[0])
now=pool[0][0]
result = 0

for start,end in pool:
  if now >end:
    continue
  elif now<start:
    now=start
  length = end-now
  if length % l ==0:
    result += length//l
    continue
  cnt = length//l+1
  now += cnt * l
  result += cnt
print(result)