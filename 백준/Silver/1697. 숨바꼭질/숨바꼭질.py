#import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

n,k = map(int,input().split())
time = [0]*100001

def bfs(x):
  q = deque()
  q.append(x)
  while q:
    nx = q.popleft()
    if nx == k:
      return time[k]
  
    if nx+1<=100000 and time[nx+1] == 0:
      q.append(nx+1)
      time[nx+1] = time[nx]+1
    if nx-1>=0 and time[nx-1] == 0:
      q.append(nx-1)
      time[nx-1] = time[nx]+1
    if nx*2 <= 100000 and time[2*nx] == 0:
      q.append(2*nx)
      time[2*nx] = time[nx]+1
res = bfs(n)  
print(res)