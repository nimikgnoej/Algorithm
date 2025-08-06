def solution(answers):
    return_list = []
    result = []
    first = [1,2,3,4,5,1,2,3,4,5]
    sec = [2,1,2,3,2,4,2,5]
    thrd = [3,3,1,1,2,2,4,4,5,5]
    first_score, sec_score, thrd_score = 0, 0, 0
    for i in range(len(answers)):
        if answers[i] == first[i%10]:
            first_score += 1
        if answers[i] == sec[i%8]:
            sec_score += 1    
        if answers[i] == thrd[i%10]:
            thrd_score += 1
        
    max_score = max(first_score, sec_score, thrd_score)
    result.append(first_score)
    result.append(sec_score)
    result.append(thrd_score)
    
    for i in range(3):
        if max_score == result[i]:
            return_list.append(i+1)
    return sorted(return_list)
        