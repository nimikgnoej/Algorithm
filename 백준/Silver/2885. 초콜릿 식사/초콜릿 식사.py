K = int(input())
i=1
choco = 0
while True:
    if i>=K:
       choco = i
       break
    i *= 2

temp = choco
count = 0
if K != choco:
    while K:
        temp //= 2
        if temp<=K:
            K -= temp
            count += 1
        else:
            count += 1
print(choco,count)