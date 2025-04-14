from collections import deque
import copy

dict = {
    "{" : "}",
    "[" : "]",
    "(" : ")"
}

def check_correct(queue):
    stack = []    
    while queue:
        target = queue.popleft()
        if len(stack) == 0:
            stack.append(target)
        else:
            top_stack = stack[-1]
            top = dict.get(top_stack)
            if top == target:
                stack.pop()
            else:
                stack.append(target)
    if not stack: # 비어있는 스택
        return True
    else:
        return False

def solution(s):
    count = 0
    q = deque()
    for c in s:
        q.append(c)
    
    for i in range(len(s)):
        char = q.popleft()
        q.append(char)
        if check_correct(copy.deepcopy(q)):
            count+=1
    return count