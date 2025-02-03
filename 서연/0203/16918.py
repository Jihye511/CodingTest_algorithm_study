import sys
from collections import deque

def bfs(q, map):
    while q:
        x,y = q.popleft()
        map[x][y] = '.'
        for i in range(4):
            nx, ny = x+dx[i], y+dy[i]
            if 0 <= nx < r and 0 <= ny < c:
                map[nx][ny] = '.'

def simulate(t):
    global q, arr
    
    if t == 1:
        for i in range(r):
            for j in range(c):
                if arr[i][j] == 'O':
                    q.append((i, j))
    
    elif t % 2 == 1:
        bfs(q, arr)
        # 남은 폭탄을 q에 다시 저장한다.
        for i in range(r):
            for j in range(c):
                if arr[i][j] == 'O':
                    q.append((i,j))
    
    else:
        arr = [['O']*c for _ in range(r)]

# 입력
r, c, n = map(int, sys.stdin.readline().split())
arr = [list(map(str, sys.stdin.readline().rstrip())) for _ in range(r)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

q = deque()

# 시뮬레이션
for i in range(1, n+1): # 1초부터 n초까지
    simulate(i)

# 출력
for i in arr:
    print(''.join(i))