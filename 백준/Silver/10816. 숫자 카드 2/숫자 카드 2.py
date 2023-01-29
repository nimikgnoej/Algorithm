import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

def binary_search(arr, start, end,target):
    if start > end:
        return 0
    
    mid = (start + end) // 2
    if arr[mid] == target:
        return cd.get(target)
    elif arr[mid] < target:
        return binary_search(arr, mid+1, end,target)
    else:
        return binary_search(arr, start, mid-1,target)

n = int(sys.stdin.readline().rstrip())
card = list(map(int,sys.stdin.readline().split()))
card.sort()
m = int(sys.stdin.readline().rstrip())
find = list(map(int,sys.stdin.readline().split()))

cd = {}
for c in card:
  if c not in cd:
    cd[c] = 1
  else:
    cd[c]+=1

for i in find:
  print(binary_search(card,0,len(card)-1,i),end=" ")