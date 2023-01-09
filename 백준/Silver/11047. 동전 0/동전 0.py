n,k=map(int,input().split())
num_list=[]
cnt=0
for i in range(n):
  num_list.append(int(input()))

for i in reversed(range(n)):
  if k ==0:
    break
  if num_list[i]>k:
    continue
  else:
    cnt+=k//num_list[i]
    k=k%(num_list[i]*(k//num_list[i]))
print(cnt)