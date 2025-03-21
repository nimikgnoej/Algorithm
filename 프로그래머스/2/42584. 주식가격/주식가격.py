from collections import deque

def solution(prices):
    q = deque(prices)
    answer= [] 
    while q:
        price = q.popleft()
        sec = 0
        for p in q:
            sec+=1
            if p < price:
                break
        answer.append(sec)
    return answer
            