import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

q = deque()
n = int(sys.stdin.readline().rstrip())

for _ in range(n):
  com = sys.stdin.readline().split()
  if com[0] == 'push':
    q.append(com[1])
  if com[0] == 'pop':
    if q:
      print(q.popleft())
    else:
      print("-1")
  if com[0] == 'size':
    print(len(q))
  if com[0] == 'empty':
    if len(q) == 0:
      print("1")
    else:
      print("0")
  if com[0] == 'front':
    if q:
      print(q[0])
    else:
      print("-1")
  if com[0] == 'back':
    if q:
      print(q[-1])
    else:
      print("-1")