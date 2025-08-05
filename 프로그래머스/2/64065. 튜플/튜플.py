def solution(s):
    answer = []
    temp = s.replace('{{','').replace('}}','').split('},{')
    temp.sort(key=lambda x : len(x))

    
    for i in temp:
        for j in i.split(','):
            j = int(j)
            if j not in answer:
                answer.append(int(j))
    return answer
    