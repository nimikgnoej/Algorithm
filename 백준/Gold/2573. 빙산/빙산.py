#import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

dx = [0,1,0,-1]
dy = [1,0,-1,0]

n,m = map(int,input().split())
ice = [list(map(int,input().split())) for _ in range(n)]
visited = [[0 for _ in range(m)]for _ in range(n)]
visit = [[0 for _ in range(m)]for _ in range(n)]
arr=[]

def melt():
  visited = [[0 for _ in range(m)]for _ in range(n)]
  for i in range(n):
    for j in range(m):
      cnt=0
      if ice[i][j] != 0:
        for k in range(4):
          nx=i+dx[k]
          ny=j+dy[k]
          if ice[nx][ny] == 0 and visited[nx][ny] == 0:
            cnt+=1
        if ice[i][j]>=cnt:
          ice[i][j]-=cnt
        else:
          ice[i][j]=0
        visited[i][j] = 1

def bfs(x,y):
  q=deque()
  q.append([x,y])
  visit[x][y] =1
  while q:
    x,y=q.popleft()
    for i in range(4):
      nx = x+dx[i]
      ny = y+dy[i]
      if ice[nx][ny] != 0 and visit[nx][ny] == 0:
        q.append([nx,ny])
        visit[nx][ny] = 1
  arr.append(1)

cnt=0
while True:
  for i in range(n):
    for j in range(m):
      if ice[i][j] != 0 and visit[i][j] == 0:
        bfs(i,j)
  if len(arr) > 1:
    print(cnt)
    break
  elif len(arr) <=1 and sum(map(sum,ice)) == 0:
    print("0")
    break
  melt()
  visit = [[0 for _ in range(m)]for _ in range(n)]
  arr= []
  cnt+=1