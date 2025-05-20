import sys

def dfs(x, y, percent, cnt):
    global answer

    if cnt == N:
        answer += percent
        return

    now_percent = percent
    graph[x][y] = 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < (2*N + 1) and 0 <= ny < (2*N + 1): # 범위 내에 있어야 함

            if graph[nx][ny] == 1: # 방문했으면 무시
                continue

            dfs(nx, ny, now_percent * (percents[i] / 100), cnt + 1)
            graph[nx][ny] = 0

# 시작
N, *percents = map(int,sys.stdin.readline().split())

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

graph = [[0] * (2*N + 1) for _ in range(2*N + 1)]

answer = 0

dfs(N, N, 1, 0)

print(answer)