n=int(input())
arr=[]
for i in range(n):
  arr.append(int(input()))
arr.sort()
res=[]
for i in range(n):
  res.append(abs(i+1-arr[i]))
print(sum(res))