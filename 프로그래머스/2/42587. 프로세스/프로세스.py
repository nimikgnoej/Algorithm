def solution(priorities, location):
    queue = []
    result = []
    for i in range(len(priorities)):
        queue.append([i,priorities[i]])
        
    while True:
        if len(queue) == 1:
            data = queue.pop(0)
            index = data[0]
            target = data[1]
            result.append([index,target])
            break
            
        data = queue.pop(0)
        index = data[0]
        target = data[1]
        if target < max(queue, key = lambda x : x[1])[1]:
            queue.append([index,target])
        else:
            result.append([index,target])
            
    for i in range(len(result)):
        if result[i][0] == location:
            return i+1
            