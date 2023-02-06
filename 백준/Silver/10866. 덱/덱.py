import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

n = int(sys.stdin.readline().rstrip())
q=deque()

for _ in range(n):
  com = sys.stdin.readline().split()
  if com[0] == 'push_back':
    q.append(int(com[1]))
  if com[0] == 'push_front':
    q.appendleft(int(com[1]))
  if com[0] == 'pop_front':
    if len(q) == 0:
      print("-1")
    else:
      print(q.popleft())
  if com[0] == 'pop_back':
    if len(q) == 0:
      print("-1")
    else:
      print(q.pop())
  if com[0] == 'size':
    print(len(q))
  if com[0] == 'empty':
    if len(q)==0:
      print("1")
    else:
      print("0")
  if com[0] == 'front':
    if len(q)==0:
      print("-1")
    else:
      print(q[0])
  if com[0] == 'back':
    if len(q)==0:
      print("-1")
    else:
      print(q[-1])