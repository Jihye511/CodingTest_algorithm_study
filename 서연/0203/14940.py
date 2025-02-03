import sys
from collections import deque

def bfs(i, j):
    queue = deque()
    queue.append((i, j))

    result[i][j] = 0

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while queue:
        x, y = queue.popleft()
        
        for i in range(4):
            nx, ny = dx[i] + x, dy[i] + y
            
            if 0 <= nx < n and 0 <= ny < m and result[nx][ny] == -1:
                if arr[nx][ny] == 0: # 갈 수 없는 땅
                    result[nx][ny] = 0
                elif arr[nx][ny] == 1: # 갈 수 있는 땅
                    result[nx][ny] = result[x][y] + 1
                    queue.append((nx, ny))

# 입력
n, m = map(int, sys.stdin.readline().split()) # 행, 열
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
# 0: 갈 수 없는 땅, 1: 갈 수 있는 땅, 2는 목표지점

result = [[-1] * m for _ in range(n)]

# 계산 - 2를 찾음
for idx, row in enumerate(arr):
    try:
        col = row.index(2)
        bfs(idx, col)
        break
    except:
        pass

# 출력
for i in range(n):
    for j in range(m):
        if arr[i][j] == 0:
            print(0, end=' ')
        else:
            print(result[i][j], end=' ')
    print()