n=int(input())
score=[]
cnt=0
for i in range(n):
  score.append(int(input()))

for i in range(n-1,0,-1):
  if score[i]<=score[i-1]:
    diff=(score[i-1]-score[i]+1)
    score[i-1]-=diff
    cnt+=diff
print(cnt)