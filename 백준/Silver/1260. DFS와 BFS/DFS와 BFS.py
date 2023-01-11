from collections import deque
n,m,v = map(int,input().split())
graph = [[0 for i in range(n+1)]for j in range(n+1)]
visited = [False] *(n+1)

for i in range(1,m+1):
  start,fin = map(int,input().split())
  graph[start][fin]=1
  graph[fin][start]=1


def dfs(v):
  visited[v]=True #시작점 방문 기록
  print(v,end=" ")
  for i in range(1,n+1):
    if visited[i]==False and graph[v][i]==1:
      dfs(i)

def bfs(v):
  queue = deque([v])
  visited[v]=True
  while queue:
    v=queue.popleft()
    print(v,end=" ")
    for i in range(1,n+1):
      if visited[i] == False and graph[v][i]==1:
        queue.append(i)
        visited[i]=True
dfs(v)
visited = [False] *(n+1)
print()
bfs(v)