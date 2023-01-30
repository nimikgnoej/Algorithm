import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

n = int(sys.stdin.readline().rstrip())
arr = list(map(int,sys.stdin.readline().split()))
x = int(sys.stdin.readline().rstrip())

exists = [False] * 2000000


cnt=0
for i in range(n):
  if (x-arr[i]) > 0 and exists[x-arr[i]]:
    cnt+=1
  exists[arr[i]] = True

print(cnt)