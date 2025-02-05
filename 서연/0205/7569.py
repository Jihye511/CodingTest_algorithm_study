import sys
from collections import deque

def bfs():
    # 상 하 좌 우 위 아래
    dx = [0, 0, -1, 1, 0, 0]
    dy = [-1, 1, 0, 0, 0, 0]
    dz = [0, 0, 0, 0, -1, 1]

    while q:
        z, x, y = q.popleft()
        for i in range(6):
            nz, nx, ny = z + dz[i], x + dx[i], y + dy[i]
            
            if 0 <= nx < n and 0 <= ny < m and 0 <= nz < h and arr[nz][nx][ny] == 0: # 범위 내에 있고, 익지 않은 토마토라면
                arr[nz][nx][ny] = arr[z][x][y] + 1
                q.append((nz, nx, ny)) 

# 입력
m, n, h = map(int, sys.stdin.readline().split()) # 가로, 세로, 높이
# arr = []
# for i in range(h):
#     arr.append([list(map(int, sys.stdin.readline().split())) for _ in range(n)])
arr = [[list(map(int, sys.stdin.readline().split())) for _ in range(n)] for _ in range(h)]


# 연산
q = deque()
for i in range(h):
    for j in range(n):
        for k in range(m):
            if arr[i][j][k] == 1:
                q.append((i, j, k)) # 층, 행, 열

bfs()

# 출력
result = 0
for floor in arr:
    for row in floor:
        if 0 in row:
            print(-1)
            sys.exit()
        result = max(result, max(row))

print(result - 1)