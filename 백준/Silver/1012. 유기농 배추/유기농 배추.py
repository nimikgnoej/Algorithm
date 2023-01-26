import sys
from collections import deque

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def bfs(x, y):
  cnt = 1
  q = deque()
  q.append([x, y])
  visited[x][y] = 1
  while q:
    x, y = q.popleft()
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if 0 <= nx < n and 0 <= ny < m:
        if field[nx][ny] == 1 and visited[nx][ny] == 0:
          q.append([nx, ny])
          visited[nx][ny] = 1
          cnt += 1
  baechu.append(cnt)


t = int(input())
while t:
  baechu = []
  m, n, k = map(int, input().split())
  field = [[0 for _ in range(m)] for _ in range(n)]
  visited = [[0 for _ in range(m)] for _ in range(n)]
  for _ in range(k):
    x, y = map(int, input().split())
    field[y][x] = 1
  for i in range(n):
    for j in range(m):
      if field[i][j] == 1 and visited[i][j] == 0:
        bfs(i, j)
  print(len(baechu))
  t -= 1