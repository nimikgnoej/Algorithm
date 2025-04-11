from collections import deque
import copy

N,M = map(int, input().split())
lab = [[0 for _ in range(M)] for _ in range(N)]

for i in range(N):
    lab[i] = list(map(int, input().split()))

def show_lab():
    for i in range(N):
        for j in range(M):
            print(lab[i][j],end=" ")
        print()

max_wall = 3
wall_count = 0
q = deque()
visited = [[0 for _ in range(M)] for _ in range(N)]

def clear_visited():
    for i in range(N):
        for j in range(M):
            visited[i][j] = 0

dx = [0,1,0,-1]
dy = [1,0,-1,0]
def spread(lab_copy):
    virus = deque()
    for i in range(N):
        for j in range(M):
            if lab_copy[i][j] == 2:
                virus.append((i,j))
    while virus:
        x,y = virus.popleft()
        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]
            if nx>=0 and nx<N and ny>=0 and ny<M:
                if lab_copy[nx][ny] == 0:
                    lab_copy[nx][ny] = 2
                    virus.append((nx,ny))
def find_zero(lab_copy):
    count = 0
    for i in range(N):
        for j in range(M):
            if lab_copy[i][j] == 0:
                count += 1
    return count


safe = []
def dfs(wall_count):
    if wall_count == max_wall:
        clear_visited()
        q.clear()
        lab_copy = copy.deepcopy(lab)
        spread(lab_copy) # 바이러스 퍼지기
        safe.append(find_zero(lab_copy))
        return
    for i in range(N):
        for j in range(M):
            if lab[i][j] == 0:
                lab[i][j] = 1
                dfs(wall_count+1)
                lab[i][j] = 0

dfs(0)
print(max(safe))