import sys
from collections import deque
input = sys.stdin.readline

m, n = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
q = deque()

for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            # 익은 토마토(1)의 좌표를 큐에 저장
            q.append([i, j])

dx, dy = [1, -1, 0, 0], [0, 0, 1, -1]
while q:
    x, y = q.popleft()
    for i in range(4):
        # 익은 토마토 상하좌우 돌면서 일수 저장
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < m:
            if arr[nx][ny] == 0:
                arr[nx][ny] = arr[x][y] + 1
                q.append([nx, ny])

ans = 0
for line in arr:
    for tomato in line:
        if tomato == 0:
            # 안익은 토마토(0)이 있으면 바로 정지
            print(-1)
            exit()
    ans = max(ans, max(line))
# 1에서 시작했기 때문에 결과 값에서 1빼주기
print(ans-1)