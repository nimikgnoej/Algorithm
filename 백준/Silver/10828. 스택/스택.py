import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

stack = deque()

n = int(sys.stdin.readline().rstrip())
for _ in range(n):
  com = sys.stdin.readline().split()
  if com[0] == 'push':
    stack.append(com[1])
  elif com[0] == 'pop':
    if stack:
      print(stack.pop())
    else:
      print('-1')
  elif com[0] == 'size':
    print(len(stack))
  elif com[0] == 'empty':
    if len(stack) == 0:
      print('1')
    else:
      print('0')
  elif com[0] == 'top':
    if stack:
      print(stack[len(stack)-1])
    else:
      print('-1')