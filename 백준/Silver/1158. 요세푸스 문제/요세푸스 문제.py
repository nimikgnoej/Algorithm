import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

n,k = map(int,sys.stdin.readline().split())
st = deque()
ans = []
cnt = 1
for i in range(n):
  st.append(i+1)

while st:  
  for i in range(k-1):
    st.append(st.popleft())
  ans.append(st.popleft())

print(f'<{", ".join(map(str,ans))}>')