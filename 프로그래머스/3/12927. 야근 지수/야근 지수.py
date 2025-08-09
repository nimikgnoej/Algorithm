import heapq

def solution(n, works):
    total_work = 0
    for w in works:
        total_work += w
    if total_work <= n:
        return 0
    
    temp = [-x for x in works]
    heapq.heapify(temp)
    
    while n>0:
        work = heapq.heappop(temp)
        work += 1
        n -= 1
        heapq.heappush(temp, work)
    
    pirodo = 0
    for t in temp:
        pirodo += (t*t)
    
    return pirodo