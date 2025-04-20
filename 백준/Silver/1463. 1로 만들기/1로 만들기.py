X = int(input())

dp = [0 for _ in range(1000001)]
dp[1] = 0
dp[2] = 1
dp[3] = 1

for i in range(4,X+1):
    if i%3==0 and i%2==0: # 6의 배수
        dp[i] = min(min(dp[i//3],dp[i//2]),dp[i-1]) + 1
    elif i%3==0:
        dp[i] = min(dp[i//3], dp[i-1]) + 1
    elif i%2==0:
        dp[i] = min(dp[i//2], dp[i-1]) + 1
    else:
        dp[i] = dp[i-1] + 1

print(dp[X])