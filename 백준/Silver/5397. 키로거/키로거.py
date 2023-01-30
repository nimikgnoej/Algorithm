import sys
#from collections import deque
#sys.stdin = open('input.txt', 'r')

tc = int(sys.stdin.readline().rstrip())

for _ in range(tc):
  st = list(sys.stdin.readline().rstrip())
  ans = []
  nst = []
  for c in st:
    if c == '<':
      if ans:
        nst.append(ans.pop())
    elif c == '>':
      if nst:
        ans.append(nst.pop())
    elif c == '-':
      if ans:
        ans.pop()
    else:
      ans.append(c)
  ans.extend(reversed(nst))
  print(''.join(ans))