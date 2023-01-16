ans =987654321
n = int(input())
graph = [[0 for _ in range(n)] for _ in range(n)]
visited = [0]*n
for i in range(n):
  graph[i] = list(map(int,input().split()))

def dfs(start,now,sum,cnt):
  global ans
  for i in range(n):
    if cnt == n:
      if graph[now][start]:
        sum += graph[now][start]
        if ans > sum:
          ans = sum
      return
    if sum > ans:
      return
    if visited[i] == 0 and graph[now][i]:
      visited[i] = 1
      dfs(start,i,sum+graph[now][i],cnt+1)
      visited[i] = 0

for i in range(n):
  visited[i]=1
  dfs(i,i,0,1)
  visited[i]=0
print(ans)