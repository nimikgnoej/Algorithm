import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    count = 0
    while len(scoville) >= 2:
        if scoville[0] >= K:
            return count
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        newFood = first + (second * 2)
        heapq.heappush(scoville, newFood)
        count += 1
    if scoville[0] >= K:
        return count
    else:
        return -1