import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

q = deque()
n = int(sys.stdin.readline().rstrip())
for i in range(n):
  q.append(i+1)

while True:
  if len(q) == 1:
    print(q.pop())
    break
  q.popleft()
  q.append(q.popleft())