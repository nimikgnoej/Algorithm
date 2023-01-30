import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

stack = deque()

n = int(sys.stdin.readline())
for _ in range(n):
  num = int(sys.stdin.readline().rstrip())
  if num == 0:
    stack.pop()
  else:
    stack.append(num)

print(sum(stack))