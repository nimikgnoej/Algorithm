import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

cnt=0
n = int(sys.stdin.readline().rstrip())
for _ in range(n):
  q=deque()
  flag = True
  inp = list(sys.stdin.readline().rstrip())
  for e in inp:
    if q and q[-1] == e:
      q.pop()
    else:
      q.append(e)
  if not q:
    cnt+=1

print(cnt)