res=0
total = int(input()) #전체 사람의 수
rel = [[] for _ in range(total+1)]
visited = [0 for _ in range(total+1)]
tar1,tar2 = map(int,input().split())
m = int(input()) #관계의 개수
for i in range(m): #관계 입력 받기
  x,y=map(int,input().split())
  rel[x].append(y)
  rel[y].append(x)

def dfs(start,cnt):
  global res
  visited[start] = 1
  if start == tar2:
    res=cnt
    return
  for i in rel[start]:
    if visited[i] == 0:
      dfs(i,cnt+1)

dfs(tar1,0)

if res==0:
  print("-1")
else:
  print(res)