import sys
from collections import deque

m, n = map(int, sys.stdin.readline().split())

map = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# 상하좌우
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

q = deque()
for i in range(n): # 0, 1, 2, 3
    for j in range(m): # 0, 1, 2, 3, 4, 5
        if map[i][j] == 1:
            q.append([i, j])

# print(q) # deque([[3, 5]])
# print(q.popleft()) # [3, 5]

def bfs():
    while q:
        x, y = q.popleft()

        for a in range(4):
            nx, ny = x + dx[a], y + dy[a]

            if 0 <= nx < n and 0 <= ny < m and map[nx][ny] == 0:
                map[nx][ny] = map[x][y] + 1
                q.append([nx, ny])


def solution():
    bfs()

    result = 0
    for row in map:
        if 0 in row:
            return -1

        row_max = max(row)
        if result < row_max:
            result = row_max

    return result - 1

print(solution())