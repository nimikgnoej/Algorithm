from collections import deque

n = int(input())
region = [list(map(int,input().split())) for _ in range(n)]
drowned = [[0 for _ in range(n)]for _ in range(n)]
visited = [[0 for _ in range(n)]for _ in range(n)]
high = max(map(max,region))
low = min(map(min,region))
dx = [0,1,0,-1]
dy = [1,0,-1,0]
safe = []
res = []

def drown(rain):
  for i in range(n):
    for j in range(n):
      if region[i][j] <rain:
        drowned[i][j] = 1

def bfs(a,b):
  q=deque()
  q.append([a,b])
  visited[a][b]=1
  while q:
    cnt=0
    x,y = q.popleft()
    for i in range(4):
      nx=x+dx[i]
      ny=y+dy[i]
      if 0<=nx<n and 0<=ny<n:
        if drowned[nx][ny]==0 and visited[nx][ny] == 0: #잠기지 않았고 방문하지 않은곳이면
          q.append([nx,ny])
          visited[nx][ny] = 1
          cnt+=1
  safe.append(cnt)

for i in range(low+1,high+1):
  drown(i)
  for j in range(n):
    for k in range(n):
      if drowned[j][k] == 0 and visited[j][k] ==0:
        bfs(j,k)
  res.append(len(safe))
  safe = []
  drowned = [[0 for _ in range(n)]for _ in range(n)]
  visited = [[0 for _ in range(n)]for _ in range(n)]

if not res:
  res.append(1)
print(max(res))