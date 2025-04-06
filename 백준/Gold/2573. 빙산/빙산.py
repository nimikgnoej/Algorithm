from collections import deque
dx = [0,1,0,-1]
dy = [1,0,-1,0]

N,M = map(int,input().split())
oceans = [[0 for _ in range(M)] for _ in range(N)]
ices = [[0 for _ in range(M)] for _ in range(N)]
q = deque()
visited = [[0 for _ in range(M)] for _ in range(N)]
iceCount = 0
year = 0

for i in range(N):
    ices[i] = list(map(int,input().split()))

def countWater():
    global oceans
    oceans = [[0 for _ in range(M)] for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if ices[i][j] != 0:
                water = 0
                for k in range(4):
                    nx = i + dx[k]
                    ny = j + dy[k]
                    if nx>=0 and ny>=0 and nx<N and ny<M:
                        if ices[nx][ny] == 0:
                            water += 1
                oceans[i][j] = water

def melt():
    global ices
    global oceans
    for i in range(N):
        for j in range(M):
            if ices[i][j] != 0:
                if ices[i][j] - oceans[i][j] < 0:
                    ices[i][j] = 0
                else:
                    ices[i][j] = ices[i][j] - oceans[i][j]

def BFS(x,y):
    global iceCount
    q.append((x,y))
    visited[x][y] = 1
    while q:
        x,y = q.popleft()
        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]
            if nx>=0 and ny>=0 and nx<N and ny<M:
                if ices[nx][ny] != 0 and visited[nx][ny] == 0:
                    q.append((nx,ny))
                    visited[nx][ny] = 1
    iceCount += 1

def updateVisited():
    global visited
    visited = [[0] * M for _ in range(N)]

def allMelted():
    for i in range(N):
        for j in range(M):
            if ices[i][j] != 0:
                return False
    return True

while True:
    updateVisited()
    countWater()
    melt()
    for i in range(N):
        for j in range(M):
            if ices[i][j] != 0 and visited[i][j] == 0:
                BFS(i,j)
    if iceCount > 1:
        print(year+1)
        break
    else:
        if allMelted():
            print(0)
            break
        year += 1
        iceCount = 0