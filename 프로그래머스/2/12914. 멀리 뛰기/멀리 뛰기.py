import math
def solution(n):
    twoMax = n // 2
    answer = 0
    for i in range(twoMax+1):
        ones = n - i*2
        if i == 0:
            answer += 1
        else:
            answer += math.comb(i+ones,i)
        
    answer = int(answer)
    return answer % 1234567