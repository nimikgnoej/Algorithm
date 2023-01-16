#import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

m,n = map(int,input().split())
graph = [[0 for _ in range(m)]for _ in range(n)]
visited = [[0 for _ in range(m)]for _ in range(n)]
dx = [0,1,0,-1]
dy = [1,0,-1,0]
q=deque()
for i in range(n):
  graph[i] = list(map(int,input().split()))

def bfs():
  while q:
    x,y = q.popleft()
    for i in range(4):
      nx = x+dx[i]
      ny = y+dy[i]
      if 0<=nx<n and 0<=ny<m:
        if graph[nx][ny] == 0 and visited[nx][ny] == 0:
          graph[nx][ny] = graph[x][y] + 1
          q.append([nx,ny])
          visited[nx][ny] = 1

for i in range(n):
  for j in range(m):
    if graph[i][j] == 1:
      q.append([i,j])
      visited[i][j]=1

def solve():
  chk = False
  for i in range(n):
    for j in range(m):
      if graph[i][j] == 0:
        print("-1")
        chk=True
        return
  if chk == False:
    print(max(map(max, graph))-1)

bfs()
solve()