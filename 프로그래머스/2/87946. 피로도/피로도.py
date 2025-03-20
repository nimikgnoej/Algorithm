answer = 0
def solution(k, dungeons):
    global answer
    def goDungeon(k, cnt, dungeons, visited):
        global answer 
        answer = max(answer, cnt)
        
        for i in range(len(dungeons)):
            if visited[i] == 0 and k >= dungeons[i][0]:
                visited[i] = 1
                goDungeon(k-dungeons[i][1], cnt+1, dungeons, visited)
                visited[i] = 0

    visited = [0] * len(dungeons)
    goDungeon(k, 0, dungeons, visited)
    
    return answer