from collections import deque

def try_to_pop(s, skill_arr):
    if s == skill_arr[0]:
        skill_arr.popleft()
        return True
    else:
        return False


def solution(skill, skill_trees):
    skill_arr = deque(skill)
    count = len(skill_trees)
    answer = 0

    for sk in skill_trees:
        dq = deque(skill)
        flag = True
        for s in sk:
            if not flag:
                continue
            if s in dq:
                if not try_to_pop(s, dq):
                    flag = False
        if flag:
            answer += 1
    return answer
            
                
        