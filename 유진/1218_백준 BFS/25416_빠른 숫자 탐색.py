import sys
from collections import deque

board = [list(map(int, sys.stdin.readline().split())) for _ in range(5)]
r, c = map(int, sys.stdin.readline().split())
visited = [[False] * 5 for _ in range(5)]

dy = [1, -1, 0, 0]
dx = [0, 0, -1, 1]


def bfs(y, x):
    q = deque([(y, x, 0)])
    visited[y][x] = True
    while q:
        y, x, cnt = q.popleft()
        if board[y][x] == 1:
            return cnt
        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]
            if 0 <= ny < 5 and 0 <= nx < 5:
                if not visited[ny][nx] and board[ny][nx] != -1:
                    visited[ny][nx] = True
                    q.append((ny, nx, cnt + 1))
    return -1


print(bfs(r, c))