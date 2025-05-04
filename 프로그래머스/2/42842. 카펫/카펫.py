def solution(brown, yellow):
    answer = []
    def check(x,y):
        target = (x+y)*2 - 4
        if target == brown:
            return True
        else:
            return False
    
    total = brown+yellow
    answerX, answerY = 0, 0
    for i in range(1,total):
        if total % i == 0:
            answerX = i
            answerY = total // i
        if(check(answerX, answerY)):
            answer.append(max(answerX,answerY))
            answer.append(min(answerX,answerY))
            return answer