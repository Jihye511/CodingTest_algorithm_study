import sys
from collections import deque

# 동 서 남 북
dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]
turn_dir = ((2, 3), (2, 3), (0, 1), (0, 1))

def bfs():
    visited = [[[0] * 4 for _ in range(N)] for _ in range(M)]
    visited[sr-1][sc-1][sd-1] = 1
    q = deque([(sr-1, sc-1, sd-1, 0)])

    while q:
        r, c, d, cnt = q.popleft()
        if (r, c, d) == (er-1, ec-1, ed-1):
            return cnt

        # 1, 2, 3칸 직진
        for dis in range(1, 4):
            nr = r + dr[d] * dis
            nc = c + dc[d] * dis
            nd = d

            # 범위 벗어나거나 벽 만나면
            if not (0 <= nr < M and 0 <= nc < N) or maps[nr][nc]:
                break

            if visited[nr][nc][nd]:
                continue

            visited[nr][nc][nd] = 1
            q.append((nr, nc, nd, cnt+1))


        # 방향 바꾸기
        for nd in turn_dir[d]:
            if visited[r][c][nd]:
                continue

            visited[r][c][nd] = 1
            q.append((r, c, nd, cnt+1))


# 1. 입력 받기
M, N = map(int, sys.stdin.readline().split())
maps = [list(map(int, sys.stdin.readline().split())) for _ in range(M)]
sr, sc, sd = map(int, sys.stdin.readline().split())
er, ec, ed = map(int, sys.stdin.readline().split())

# 2. 시행
print(bfs())