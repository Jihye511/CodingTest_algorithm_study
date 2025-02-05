import sys
from collections import deque

def bfs():    
    # 위, 아래, 왼, 오
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
             # 범위 내에 있고, 익지 않은 토마토인 경우(이걸 체크 안하면 더 적게 갈 수 있는 곳인데 더 많이 갈 수 있는 곳으로 계산 됨)
            if 0 <= nx < n and 0 <= ny < m and arr[nx][ny] == 0:
                arr[nx][ny] = arr[x][y] + 1
                q.append((nx, ny))

# 입력
# 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
m, n = map(int, sys.stdin.readline().split()) # 열, 행
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# 먼저 익은 토마토를 찾아서 q에 넣는다.
q = deque()
for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            q.append((i, j))

# 실행
bfs()  

# 출력
for row in arr:
    if 0 in row: # 익지 않은 토마토가 있는 경우 -1 출력
        print(-1)
        sys.exit()
else:
    print(max(map(max, arr))-1)