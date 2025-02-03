import sys
from collections import deque

N, M = map(int, sys.stdin.readline().split())

graph = []
for i in range(N):
    graph.append(list(map(int, sys.stdin.readline().split())))

visited = [[-1] * M for _ in range(N)]

#    상  하  좌  우
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]


def bfs(i, j):
    queue = deque()        # queue 생성
    queue.append((i, j))   # queue에 시작 지점 넣기

    visited[i][j] = 0

    while queue: # queue가 빌 때까지 실행
        x, y = queue.popleft()

        for i in range(4):
            next_x = x + dx[i]
            next_y = y + dy[i]

            if 0 <= next_x < N and 0 <= next_y < M and visited[next_x][next_y] == -1:   # 범위 확인
                if graph[next_x][next_y] == 0:  # 갈 수 없는 땅일 때
                    visited[next_x][next_y] = 0

                elif graph[next_x][next_y] == 1: # 갈 수 있는 땅일 때
                    visited[next_x][next_y] = visited[x][y] + 1
                    queue.append((next_x, next_y))


for i in range(N):
    for j in range(M):
        if graph[i][j] == 2 and visited[i][j] == -1:
            bfs(i, j)

for i in range(N):
    for j in range(M):
        if graph[i][j] == 0:
            print(0, end=' ')
        else:
            print(visited[i][j], end=' ')
    print()

