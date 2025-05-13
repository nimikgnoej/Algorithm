from collections import deque

T = int(input())
dx=[0,1,0,-1]
dy=[1,0,-1,0]

def printBoard(board):
    for i in range(M):
        for j in range(N):
            print(board[i][j], end=" ")
        print()

def bfs(q, x,y, visited,board):
    q.append((x,y))
    visited[x][y] = 1
    while q:
        x,y = q.popleft()
        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]
            if nx>=0 and nx<M and ny>=0 and ny<N:
                if board[nx][ny] == 1 and visited[nx][ny] == 0:
                    q.append((nx,ny))
                    visited[nx][ny] = 1

for t in range(T):
    M,N,K = map(int,input().split())
    board = [[0 for _ in range(N)] for _ in range(M)]
    visited = [[0 for _ in range(N)] for _ in range(M)]
    q = deque()
    count = 0
    for i in range(K):
        baechux,baechuy = map(int,input().split())
        board[baechux][baechuy] = 1

    for i in range(M):
        for j in range(N):
            if board[i][j] == 1 and visited[i][j] == 0:
                bfs(q,i,j,visited,board)
                count += 1
    print(count)