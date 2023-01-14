n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]
visited = [0]*(n+1)

for i in range(m):
  start,end = map(int,input().split())
  graph[start].append(end)
  graph[end].append(start)

def dfs(x):
  visited[x]=1
  for i in graph[x]:
    if not visited[i]:
      dfs(i)
dfs(1)
print(sum(visited)-1)