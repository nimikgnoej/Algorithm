n=int(input())
users=[]
for i in range(n):
  age,name = input().split()
  users.append([int(age),name])
users.sort(key = lambda x:x[0])

for i in range(n):
  print(f"{users[i][0]} {users[i][1]}")