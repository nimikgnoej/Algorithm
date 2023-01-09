n=int(input())
meeting = []
cnt=1
for i in range(n):
  meeting.append(list((map(int,input().split()))))
meeting.sort(key = lambda x: (x[1],x[0]))

time=meeting[0][1]
for i in range(1,n):
  if time<=meeting[i][0]:
    cnt+=1
    time=meeting[i][1]
print(cnt)