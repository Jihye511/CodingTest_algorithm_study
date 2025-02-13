import sys

def dfs(x, y):
    global answer

    if (x, y) == (n+1, 1):
        answer += 1
        return

    if y == m:
        nx, ny = x + 1, 1
    else:
        nx, ny = x, y + 1

    # 현재 위치를 넣지 않는 경우
    dfs(nx, ny)

    # 현재 위치를 사용하는 경우
    if maps[x][y-1] == 0 or maps[x-1][y] == 0 or maps[x-1][y-1] == 0:
        maps[x][y] = 1
        dfs(nx, ny)

        # 복원
        maps[x][y] = 0

n, m = map(int, sys.stdin.readline().split())
maps = [[0] * (m+1) for _ in range(n+1)]

answer = 0
dfs(1, 1)
print(answer)