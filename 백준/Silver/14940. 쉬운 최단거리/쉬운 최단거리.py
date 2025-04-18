from collections import deque

dx = [0,1,0,-1]
dy = [1,0,-1,0]
N,M = map(int,input().split())
board = [[0 for _ in range(M)] for _ in range(N)]
visited = [[0 for _ in range(M)] for _ in range(N)]
for i in range(N):
    board[i] = list(map(int,input().split()))

q = deque()

answer = [[0 for _ in range(M)] for _ in range(N)]
def bfs(x,y):
    dist = 1
    visited[x][y] = 1
    q.append((x,y,dist))
    while q:
        x,y,d = q.popleft()
        dist = d
        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]
            if nx>=0 and nx<N and ny>=0 and ny<M:
                if board[nx][ny]==1 and visited[nx][ny] == 0:
                    answer[nx][ny] = dist
                    q.append((nx,ny,dist+1))
                    visited[nx][ny] = 1

for i in range(N):
    for j in range(M):
        if board[i][j] == 2:
            bfs(i,j)

for i in range(N):
    for j in range(M):
        if answer[i][j]==0 and board[i][j]==1:
            answer[i][j] = -1

for i in range(N):
    for j in range(M):
        print(answer[i][j],end=" ")
    print()