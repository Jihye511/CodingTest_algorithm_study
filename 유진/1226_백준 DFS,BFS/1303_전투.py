import sys
from collections import deque

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y, color):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    count = 1

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < M and 0 <= ny < N:
                if not visited[nx][ny] and war[nx][ny] == color:
                    visited[nx][ny] = True
                    q.append((nx, ny))
                    count += 1

    return count

N, M = map(int, sys.stdin.readline().split())

war = []
for _ in range(M):
    war.append(sys.stdin.readline().strip())


visited = [[False] * N for _ in range(M)]



blue = 0
white = 0

for i in range(M):
    for j in range(N):
        if not visited[i][j] and war[i][j] == 'B':
            blue += bfs(i, j, war[i][j]) ** 2

        elif not visited[i][j] and war[i][j] == 'W':
            white += bfs(i, j, war[i][j]) ** 2


print(white, blue)