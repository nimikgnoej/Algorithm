import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

st=[]
ans=[]
cur = 1
chk = 0

n = int(sys.stdin.readline())
for i in range(n):
  tar = int(sys.stdin.readline().rstrip())
  while cur <= tar:
    st.append(cur)
    ans.append('+')
    cur +=1
  if tar == st[-1]:
    st.pop()
    ans.append('-')
  else:
    print('NO')
    chk=1
    break

if chk == 0:
  for c in ans:
    print(c)