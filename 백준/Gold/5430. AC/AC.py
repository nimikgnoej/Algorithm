import sys
from collections import deque
#sys.stdin = open('input.txt', 'r')

def print_q(q):
  print('[',end='')
  for i in range(len(q)):
    print(q[i],end='')
    if i != len(q)-1:
      print(",",end='')
  print(']')

T = int(sys.stdin.readline().rstrip())
for _ in range(T): #T개의 테스트 케이스
  flag = 0
  rev = 0
  functions = list(sys.stdin.readline().rstrip())
  num = int(sys.stdin.readline())
  arr = list(sys.stdin.readline().strip('['']''\n').split(','))
  if arr[0] =='':
    arr.clear()
  q=deque(arr)
  for function in functions:
    if function == 'R':
      rev = 1-rev
    else:
      if not q:
        flag = 1
        break
      if rev==1: #뒤집힌 상태
        q.pop()
      else:
        q.popleft()
  if flag == 1:
    print("error")
  else:
    if rev == 1:
      q.reverse()
    print_q(q)