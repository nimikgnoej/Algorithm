def solution(topping):
    answer = 0
    left = {}
    right = {}
    for t in topping:
        if t not in left:
            left[t] = 1
        else:
            left[t] += 1
            
    for t in topping:
        if len(left) == len(right):
            answer += 1
        if t not in right:
            right[t] = 1
        left[t] -= 1
        if left[t] == 0:
            del left[t]
    return answer