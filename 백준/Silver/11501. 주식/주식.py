t=int(input())
while t>0:
  cnt=0
  budget=0
  n=int(input())
  cost=list(map(int,input().split()))
  max_cost = 0
  for i in range(n-1,-1,-1):
    if max_cost<cost[i]:
      max_cost=cost[i]
    else:
      budget += max_cost - cost[i]
  print(budget)
  t-=1