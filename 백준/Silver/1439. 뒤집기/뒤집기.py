line = list(map(int,input()))
zero_cnt=0
one_cnt=0

for i in range(len(line)):
  if i==0:
    if line[i]==0:
      zero_cnt+=1
    else:
      one_cnt+=1
  elif line[i-1]!=line[i]:
    if line[i] ==1: #01 조합이다
      one_cnt+=1
    else:
      zero_cnt+=1
print(min(one_cnt,zero_cnt))