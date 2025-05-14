from collections import deque

N,K = map(int,input().split())

board = [0 for _ in range(200010)]
visited = [0 for _ in range(200010)]
q = deque()
def bfs(x):
    q.append(x)
    visited[x] = 1
    while q:
        x = q.popleft()
        if x-1 >=0 and visited[x-1] == 0:
            board[x-1] = board[x] + 1
            q.append(x-1)
            visited[x-1]=1
        if x+1 <= 100001 and visited[x+1] == 0:
            board[x + 1] = board[x] + 1
            q.append(x+1)
            visited[x + 1] = 1
        if 2*x <= 100001 and visited[2*x] == 0:
            board[x * 2] = board[x] + 1
            q.append(2*x)
            visited[2*x] = 1
        if visited[K] == 1:
            return

bfs(N)
print(board[K])