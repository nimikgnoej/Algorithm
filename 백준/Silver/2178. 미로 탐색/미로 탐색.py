from collections import deque
n,m = map(int,input().split())
graph = []
visited=[[0 for i in range(m)]for j in range(n)]
dx=[0,1,0,-1]
dy=[1,0,-1,0]

for i in range(n):
  graph.append(list(map(int,input())))

def bfs():
  q=deque()
  q.append([0,0])
  visited[0][0]=1
  while q:
    x,y=q.popleft()
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]
      if 0<=nx<n and 0<= ny<m:
        if graph[nx][ny] ==1 and visited[nx][ny]==0:
          q.append([nx,ny])
          visited[nx][ny]=1
          graph[nx][ny] = graph[x][y]+1
bfs()
print(graph[n-1][m-1])