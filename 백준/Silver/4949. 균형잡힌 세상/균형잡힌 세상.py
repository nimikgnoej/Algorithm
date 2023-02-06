import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

while True:
  inp = list(sys.stdin.readline().rstrip())
  flag = 0
  if inp[0] == '.' and len(inp)==1:
    break
  q=deque()
  for e in inp:
    if e == '(' or e =='[':
      q.append(e)
    elif e == ')':
      if '(' not in q:
        q.append(e)
      elif q[-1] == '(':
        q.pop()
      else:
        break
    elif e == ']':
      if '[' not in q:
        q.append(e)
      elif q[-1] == '[':
        q.pop()
      else:
        break
  if q:
    print("no")
  else:
    print("yes")