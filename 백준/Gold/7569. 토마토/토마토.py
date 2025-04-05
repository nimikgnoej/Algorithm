from collections import deque 
M, N, H = map(int, input().split())
box = []
visited = [[[0 for _ in range(M)] for _ in range(N)] for _ in range(H)]
dx = [0,1,0,-1,0,0]
dy = [1,0,-1,0,0,0]
dz = [0,0,0,0,-1,1]
q = deque()

for _ in range(H):
    sub = []
    for _ in range(N):
        sub.append(list(map(int, input().split())))
    box.append(sub)
def bfs():
    while q:
        h,n,m = q.popleft()
        for k in range(6):
            nn = n + dx[k]
            nm = m + dy[k]
            nh = h + dz[k]
            if nn >= 0 and nm >= 0 and nh >= 0 and nn < N and nm < M and nh < H:
                if box[nh][nn][nm] == 0 and visited[nh][nn][nm] == 0:
                    box[nh][nn][nm] = box[h][n][m] + 1
                    q.append((nh,nn,nm))
                    visited[nh][nn][nm] = 1

for height in range(H):
    for sero in range(N):
        for garo in range(M):
            if box[height][sero][garo] == 1 and visited[height][sero][garo] == 0:
                q.append((height,sero,garo))
                visited[height][sero][garo] = 1
bfs()
ans = 0
for a in box:
    for b in a:
        for c in b:
            if c == 0:
                print(-1)
                exit(0)
        ans = max(ans, max(b))
print(ans-1)
