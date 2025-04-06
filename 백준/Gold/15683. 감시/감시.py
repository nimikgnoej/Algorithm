import copy
N,M = map(int,input().split())
office = [[0 for _ in range(M)] for _ in range(N)]

dx = [0,1,0,-1]
dy = [1,0,-1,0]
directions = [
    [],
    [[0],[1],[2],[3]],
    [[0,2],[1,3]],
    [[3,0],[0,1],[1,2],[2,3]],
    [[2,3,0],[3,0,1],[0,1,2],[1,2,3]],
    [[0,1,2,3]]
]
cctv = []
min_val = int(1e9)

for i in range(N):
    office[i] = list(map(int,input().split()))

for i in range(N):
    for j in range(M):
        if office[i][j] in [1,2,3,4,5]:
            cctv.append((i,j,office[i][j]))


def fill(x,y,dir,office):
    for k in dir:
        nx = x
        ny = y
        while True:
            nx += dx[k]
            ny += dy[k]
            if nx<0 or nx>=N or ny<0 or ny>=M:
                break
            if office[nx][ny] == 6:
                break
            if office[nx][ny] in [1,2,3,4,5]:
                continue
            else:
                office[nx][ny] = "#"

def DFS(depth, office):
    global min_val
    if depth == len(cctv): # 끝
        count = 0
        for i in range(N):
            count += office[i].count(0)
        min_val = min(min_val,count)
        return
    x,y,cctvNum = cctv[depth]
    temp = copy.deepcopy(office)
    for i in directions[cctvNum]:
        fill(x,y,i,temp)
        DFS(depth+1, temp)
        temp = copy.deepcopy(office)

DFS(0,office)
print(min_val)