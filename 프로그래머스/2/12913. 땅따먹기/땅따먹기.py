def solution(land):
    N = len(land)
    dp = [[0 for _ in range(4)] for _ in range(N+1)]
    
    dp[1][0] = land[0][0]
    dp[1][1] = land[0][1]
    dp[1][2] = land[0][2]
    dp[1][3] = land[0][3]
    
    for i in range(2, N+1):
        dp[i][0] = max(dp[i-1][1], dp[i-1][2], dp[i-1][3]) + land[i-1][0]
        dp[i][1] = max(dp[i-1][0], dp[i-1][2], dp[i-1][3]) + land[i-1][1]
        dp[i][2] = max(dp[i-1][0], dp[i-1][1], dp[i-1][3]) + land[i-1][2]
        dp[i][3] = max(dp[i-1][0], dp[i-1][1], dp[i-1][2]) + land[i-1][3]
    
    return max(dp[N])