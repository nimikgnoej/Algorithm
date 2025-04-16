N = int(input())
RGB = []
for i in range(N):
    RGB.append(list(map(int,input().split())))

dp = [[0 for _ in range(3)] for _ in range(N+1)]
dp[1][0] = RGB[0][0]
dp[1][1] = RGB[0][1]
dp[1][2] = RGB[0][2]
for i in range(2, N+1):
    dp[i][0] = min(dp[i-1][1] + RGB[i-1][0], dp[i-1][2] + RGB[i-1][0])
    dp[i][1] = min(dp[i-1][0] + RGB[i-1][1], dp[i-1][2] + RGB[i-1][1])
    dp[i][2] = min(dp[i-1][1] + RGB[i-1][2], dp[i-1][0] + RGB[i-1][2])

print(min(dp[N][0], min(dp[N][1], dp[N][2])))
