from collections import deque

def solution(tickets):
    answer = []
    tickets.sort()
    country_count = len(tickets)
    visited = [False] * country_count
    used = deque()
    
    def dfs(path):
        if len(path) == country_count+1:
            answer.append(path[:])
            return
        for i in range(country_count):
            if tickets[i][0] == path[-1] and visited[i] == False:
                visited[i] = True
                path.append(tickets[i][1])
                dfs(path)
                path.pop()
                visited[i] = False
                
    dfs(["ICN"])
    return answer[0]