import sys
#from collections import deque
#sys.stdin = open('input.txt', 'r')

st = list(sys.stdin.readline().rstrip())
nst = []
m=int(sys.stdin.readline())

for _ in range(m):
  inp = sys.stdin.readline().split()
  if inp[0] == 'L':
    if st:
      nst.append(st.pop())
  elif inp[0] == 'D':
    if nst:
      st.append(nst.pop())
  elif inp[0] == 'B':
    if st:
      st.pop()
  else:
    st.append(inp[1])

st.extend(reversed(nst))
print(''.join(st))