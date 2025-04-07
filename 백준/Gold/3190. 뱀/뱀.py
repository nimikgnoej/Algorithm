from collections import deque
N = int(input())
apple_count = int(input())
apple = [(0,0) for _ in range(apple_count)]
for i in range(apple_count):
    x,y = map(int,input().split())
    apple[i] = (x-1,y-1)
snake_count = int(input())
snake_info = []
snake_q = deque()
for i in range(snake_count):
    time,dir = input().split()
    time = int(time)
    snake_q.append((time,dir))

dx = [0,1,0,-1]
dy = [1,0,-1,0]
board = [[0 for _ in range(N)] for _ in range(N)]
board[0][0] = 1

direction = 0

def turnLeft():
    global direction
    if direction == 0:
        direction = 3
    else:
        direction -= 1

def turnRight():
    global direction
    if direction == 3:
        direction = 0
    else:
        direction += 1

time = 0
snake_body = deque([(0, 0)])
board[0][0] = 1
while True:
    time += 1
    headx, heady = snake_body[-1]
    nx, ny = headx + dx[direction], heady + dy[direction]

    if not (0 <= nx < N and 0 <= ny < N) or (nx, ny) in snake_body:
        print(time)
        break

    snake_body.append((nx, ny))

    if (nx, ny) in apple:
        apple.remove((nx, ny))
    else:
        snake_body.popleft()

    if snake_q and time == snake_q[0][0]:
        _, d = snake_q.popleft()
        if d == 'D':
            turnRight()
        else:
            turnLeft()