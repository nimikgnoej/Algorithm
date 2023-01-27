from collections import deque

totalF,nowS,destG,up,down = map(int,input().split())
dist = [0]*(totalF+1)
visited = [0]*(totalF+1)

def startlink(now):
  q=deque()
  q.append(now)
  dist[now]=0
  visited[now]=1
  while q:
    new = q.popleft()
    if new == destG:
      return dist[new]
    if new+up <=totalF and visited[new+up] == 0:
      q.append(new+up)
      visited[new+up]=1
      dist[new+up] = dist[new]+1
    if new-down >=1 and visited[new-down] == 0:
      q.append(new-down)
      visited[new-down]=1
      dist[new-down] = dist[new]+1
res=startlink(nowS)
if res ==None:
  print("use the stairs")
else:
  print(res)