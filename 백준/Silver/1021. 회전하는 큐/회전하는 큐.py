import sys
from collections import deque
#ys.stdin = open('input.txt', 'r')

q = deque()
n,m = map(int,sys.stdin.readline().split())
want = list(map(int,sys.stdin.readline().split()))
cnt = 0
for i in range(n):
  q.append(i+1)

for tar in want:
  if tar == q[0]:
    q.popleft()
  elif q.index(tar) <= len(q)//2:
    while True:
      if tar ==q[0]:
        q.popleft()
        break
      q.append(q.popleft())
      cnt+=1
  elif q.index(tar) > len(q)//2:
    while True:
      if tar == q[0]:
        q.popleft()
        break
      q.appendleft(q.pop())
      cnt+=1

print(cnt)