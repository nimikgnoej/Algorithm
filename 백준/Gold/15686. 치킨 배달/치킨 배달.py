N,M = map(int,input().split())
city = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N):
    city[i] = list(map(int,input().split()))

answer = int(1e9)

chickens = []
house = []
for i in range(N):
    for j in range(N):
        if city[i][j] == 2:
            chickens.append((i,j))
        elif city[i][j] == 1:
            house.append((i,j))
selected = [0 for _ in range(len(chickens))]

def check_distance():
    total_distance = 0
    global selected
    global city
    global answer
    for hx,hy in house:
        distance = int(1e9)
        for i in range(len(chickens)):
            if selected[i]:
                cx = chickens[i][0]
                cy = chickens[i][1]
                distance = min(distance, abs(hx-cx)+abs(hy-cy))
        total_distance += distance
    answer = min(answer, total_distance)
    return

def dfs(depth,index):
    if depth == M:
        check_distance()
        return

    for i in range(index, len(chickens)):
        if not selected[i]:
            selected[i] = 1
            dfs(depth+1, i+1)
            selected[i] = 0


dfs(0,0)
print(answer)