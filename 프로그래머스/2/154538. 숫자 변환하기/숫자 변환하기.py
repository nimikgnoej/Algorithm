def solution(x, y, n):
    dp = [1e9 for _ in range(1000001)]
    dp[x] = 0

    for i in range(x+1, y + 1):
        if i % 6 == 0:  # 6배수
            if dp[i-n] == 1e9 and dp[i//2] == 1e9 and dp[i//3] == 1e9:
                continue
            dp[i] = min(dp[i - n], min(dp[i // 2], dp[i // 3])) + 1
        elif i % 3 == 0:
            if dp[i - n] == 1e9 and dp[i // 3] == 1e9:
                continue
            dp[i] = min(dp[i - n], dp[i // 3]) + 1
        elif i % 2 == 0:
            if dp[i - n] == 1e9 and dp[i // 2] == 1e9:
                continue
            dp[i] = min(dp[i - n], dp[i // 2]) + 1
        else:
            if dp[i - n] == 1e9:
                continue
            dp[i] = dp[i - n] + 1

    if dp[y] == 1e9:
        return -1
    else:
        return dp[y]


