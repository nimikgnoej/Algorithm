def solution(want, number, discount):
    count = 0
    possibleDay = len(discount) - 10
    for i in range(possibleDay+1):
        flag = True
        subList = discount[i:i+10]
        for j in range(len(want)):
            if number[j] != subList.count(want[j]):
                flag = False
        if flag == True: # 모두 다 맞았다는 거
            count += 1
    return count