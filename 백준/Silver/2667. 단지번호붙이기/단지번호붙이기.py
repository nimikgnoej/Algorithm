import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

n = int(input())
map = [[0 for _ in range(n+1)] for _ in range(n+1)]
visited = [[0 for _ in range(n+1)] for _ in range(n+1)]
dx = [0,1,0,-1]
dy = [1,0,-1,0]
village = []

for i in range(n):
  map[i] = list(input())

def bfs(x,y):
  q=deque()
  q.append((x,y))
  visited[x][y] = 1
  village.append(1)
  while q:
    x,y=q.popleft()
    for i in range(4):
      nx = x+dx[i]
      ny = y+dy[i]
      if 0<=nx<n and 0<=ny<n:
        if map[nx][ny] == '1' and visited[nx][ny] == 0:
          q.append((nx,ny))
          visited[nx][ny]=1
          village[-1]+=1

for i in range(n):
  for j in range(n):
    if map[i][j] == '1' and visited[i][j]==0:
      bfs(i,j)
village.sort()
print(len(village))
for i in range(len(village)):
  print(village[i])