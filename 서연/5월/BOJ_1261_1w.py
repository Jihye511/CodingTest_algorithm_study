import sys
import heapq

M, N = map(int, sys.stdin.readline().split())
arr = [list(map(int, sys.stdin.readline().strip())) for _ in range(N)]
distance = [[1e9] * M for _ in range(N)]

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def sol():
    q = []
    heapq.heappush(q, (0, 0, 0))
    distance[0][0] = 0

    while q:
        cost, x, y = heapq.heappop(q)

        if cost > distance[x][y]:
            continue

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= M:  # 범위를 벗어나거나 이미 방문했으면
                continue

            if cost + arr[nx][ny] < distance[nx][ny]:
                distance[nx][ny] = cost + arr[nx][ny]
                heapq.heappush(q, (distance[nx][ny], nx, ny))


sol()
print(distance[N - 1][M - 1])