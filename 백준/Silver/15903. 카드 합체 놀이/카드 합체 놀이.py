import sys
#from collections import deque
import heapq
#sys.stdin = open('input.txt', 'r')

n,m = map(int,input().split())
q = list(map(int,input().split()))
heapq.heapify(q)
while m:
  a=heapq.heappop(q)
  b=heapq.heappop(q)
  heapq.heappush(q,a+b)
  heapq.heappush(q,a+b)
  m-=1
print(sum(q))