import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

n = int(sys.stdin.readline().rstrip())
arr = list(map(int,sys.stdin.readline().split()))
x = int(sys.stdin.readline().rstrip())
arr.sort()

cnt=0
left = 0
right = n-1
while left < right:
  if arr[left]+arr[right] == x:
    cnt+=1
    left+=1
    right-=1
  elif arr[left]+arr[right]>x:
    right-=1
  else:
    left+=1

print(cnt)