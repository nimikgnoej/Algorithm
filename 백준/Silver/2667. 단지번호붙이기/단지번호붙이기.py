N = int(input())
village = []
for i in range(N):
    village.append(list(map(int, list(input()))))
visited = [[0 for _ in range(N)] for _ in range(N)]
dx = [0,1,0,-1]
dy = [1,0,-1,0]
q = []
result = []
def bfs(x,y):
    count = 1
    visited[x][y] = 1
    q.append((x,y))
    while len(q) != 0:
        data = q.pop(0)
        x = data[0]
        y = data[1]
        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]
            if nx >= 0 and nx < N and ny >= 0 and ny < N:
                if village[nx][ny] == 1 and visited[nx][ny] == 0:
                    q.append((nx,ny))
                    visited[nx][ny] = 1
                    count += 1
    result.append(count)


for i in range(N):
    for j in range(N):
        if village[i][j] == 1 and visited[i][j] == 0:
            bfs(i,j)
print(len(result))
answer = sorted(result)
for i in range(len(result)):
    print(answer[i])