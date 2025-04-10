from collections import deque
R,C,T = map(int,input().split())
board = [[0 for _ in range(C)] for _ in range(R)]
#
for i in range(R):
    board[i] = list(map(int,input().split()))
# board = [
#     [0,30,7],
#     [-1,10,0],
#     [-1,0,20]
# ]
# R,C = 3,3
def show_board():
    for i in range(R):
        for j in range(C):
            print(board[i][j], end=" ")
        print()

purifier = []
dust_info = []
dx = [0,1,0,-1]
dy = [1,0,-1,0]
def check(x,y, dif_amt):
    count = 0
    for k in range(4):
        nx = x+dx[k]
        ny = y+dy[k]
        if nx>=0 and nx<R and ny>=0 and ny<C:
            if board[nx][ny] != -1:
                count += 1
                board[nx][ny] += dif_amt
    return count

def diffusion():
    purifier.clear()
    dust_info.clear()
    for i in range(R):
        for j in range(C):
            if board[i][j] != 0 and board[i][j] != -1: # 먼지일 경우
                dust_info.append((i,j, int(board[i][j]/5)))
            elif board[i][j] == -1:
                purifier.append((i,j))

    for d in dust_info:
        x = d[0]
        y = d[1]
        dif_amount = d[2]
        c = check(x,y,dif_amount)
        board[x][y] = board[x][y] - c*dif_amount


def operate_top():
    right = deque()
    left = deque()
    top_purifier = purifier[0]
    top_x = top_purifier[0]
    temp_right = board[top_x][1:C-1] # 오른쪽바람
    for i in range(top_x,0,-1): # 위쪽바람
        right.append(board[i][C-1])
    temp_left = board[0][1:] # 왼쪽바람
    for i in range(0,top_x):
        left.append(board[i][0])

    board[top_x][1] = 0
    board[top_x][2:] = temp_right
    for i in range(top_x-1,-1,-1):
        board[i][C-1] = right.popleft()
    board[0][0:C-1] = temp_left
    for i in range(1,top_x):
        board[i][0] = left.popleft()

def operate_down():
    right = deque()
    left = deque()
    down_purifier = purifier[1]
    down_x = down_purifier[0] # down_x = 3
    temp_right = board[down_x][1:C - 1]  # 오른쪽바람
    for i in range(down_x, R-1):  # 아래바람
        right.append(board[i][C - 1])
    temp_left = board[R-1][1:]  # 왼쪽바람
    for i in range(R-1, down_x, -1): # 윗 바람
        left.append(board[i][0])

    board[down_x][1] = 0
    board[down_x][2:] = temp_right
    for i in range(down_x+1, R):
        board[i][C - 1] = right.popleft()
    board[R-1][0:C - 1] = temp_left
    for i in range(R-2, down_x, -1):
        board[i][0] = left.popleft()

def check_dust_count():
    sum = 0
    for i in range(R):
        for j in range(C):
           if board[i][j] != -1:
               sum += board[i][j]
    return sum

while T>0:
    diffusion()
    operate_top()
    operate_down()
    T -= 1

dust_count = check_dust_count()

print(dust_count)
