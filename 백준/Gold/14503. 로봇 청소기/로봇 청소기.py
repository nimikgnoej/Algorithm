N,M = map(int,input().split())
r,c,d = map(int,input().split())
dx = [0,1,0,-1]
dy = [1,0,-1,0]
count = 0

room = [[0 * M] for _ in range(N)]
visited = [[0 for _ in range(M)] for _ in range(N)]

for i in range(N):
    room[i] = list(map(int,input().split()))

direction = {
    0 : (-1,0),
    1 : (0,1),
    2 : (1,0),
    3 : (0,-1)
}

def turn90():
    global d
    if d>0:
        d-=1
    else:
        d=3

def clean(x,y):
    global count
    if visited[x][y] == 0:
        visited[x][y] = 1
        count += 1

def find(x,y):
    for k in range(4):
        nx = x+dx[k]
        ny = y+dy[k]
        if nx>=0 and nx<N and ny>=0 and ny<M:
            if room[nx][ny] == 0 and visited[nx][ny] == 0:
                return True
    return False

while True:
    clean(r,c)
    if find(r,c):
        turn90()
        ax,ay = direction.get(d)
        if room[r+ax][c+ay] == 0 and visited[r+ax][c+ay] == 0:
            r=r+ax
            c=c+ay
    else:
        ax,ay = direction.get(d)
        if room[r-ax][c-ay] == 1: # 벽이라면
            print(count)
            break
        else:
            r=r-ax
            c=c-ay