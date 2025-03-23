def solution(k, tangerine):
    answer = 0
    data = {}
    for t in tangerine:
        if t not in data:
            data[t] = 1
        else:
            data[t] += 1
            
    data = dict(sorted(data.items(), key=lambda x : x[1], reverse=True))
    
    for i in data:
        if k<=0:
            return answer
        k -= data[i]
        answer += 1
    return answer
            
        