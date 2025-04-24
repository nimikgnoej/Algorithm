from collections import deque

dx = [0,1,0,-1]
dy = [1,0,-1,0]

n,m = map(int,input().split())
board = [[0 for _ in range(m)] for _ in range(n)]
for i in range(n):
    board[i] = list(map(int,input().split()))
q = deque()
visited = [[0 for _ in range(m)] for _ in range(n)]

def bfs(x,y):
    area = 1
    q.append((x,y))
    visited[x][y] = 1
    while q:
        x,y = q.popleft()
        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]
            if nx>=0 and nx<n and ny>=0 and ny<m:
                if board[nx][ny] == 1 and visited[nx][ny] == 0:
                    q.append((nx,ny))
                    visited[nx][ny] = 1
                    area += 1
    return area

answer = []
for i in range(n):
    for j in range(m):
        if board[i][j] == 1 and visited[i][j] == 0:
            area = bfs(i,j)
            answer.append(area)
if len(answer) == 0:
    print(0)
    print(0)
else:
    print(len(answer))
    print(max(answer))