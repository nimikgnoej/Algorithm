import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

dx = [-2,-1,1,2,2,1,-1,-2]
dy = [1,2,2,1,-1,-2,-2,-1]

def bfs(x,y):
  visited[x][y] = 1
  q = deque([(x,y)])
  while q:
    x,y = q.popleft()
    for i in range(8):
      nx = x+dx[i]
      ny = y+dy[i]
      if 0<=nx<size and 0<=ny<size:
        if visited[nx][ny] == 0:
          q.append([nx,ny])
          visited[nx][ny] = 1
          dist[nx][ny] = dist[x][y]+1

t = int(sys.stdin.readline().rstrip())
for _ in range(t):
  size = int(sys.stdin.readline().rstrip())
  chess = [[0 for _ in range(size)] for _ in range(size)]
  visited = [[0 for _ in range(size)] for _ in range(size)]
  dist = [[0 for _ in range(size)] for _ in range(size)]
  nowx,nowy = map(int,sys.stdin.readline().split())
  targetx,targety = map(int,sys.stdin.readline().split())
  bfs(nowx,nowy)
  print(dist[targetx][targety])