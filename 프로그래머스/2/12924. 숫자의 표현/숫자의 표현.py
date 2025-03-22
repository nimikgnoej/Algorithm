def solution(n):
    count = 0
    for i in range(1,n):
        sum = i
        for j in range(i+1,n):
            sum += j
            if sum == n:
                count += 1
                break
            elif sum > n:
                break
    return count+1