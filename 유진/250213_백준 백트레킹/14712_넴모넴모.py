import sys
input = sys.stdin.readline
N, M = map(int, input().split())
square_map = [[0] * (M + 1) for _ in range(N + 1)]
count = 0

def dfs(x, y):
    global count
    if (x, y) == (N + 1, 1):
        count += 1
        return

    if y == M:
        nx, ny = x + 1, 1
    else:
        nx, ny = x, y + 1

    # 현재 위치를 넣지 않는 경우
    dfs(nx, ny)

    # 현재 위치를 사용하는 경우(다만 현재 위치를 기준으로 왼쪽, 위쪽, 좌상단에 넴모가 하나라도 없어야 가능)
    if square_map[x][y - 1] == 0 or square_map[x - 1][y] == 0 or square_map[x - 1][y - 1] == 0:
        square_map[x][y] = 1
        dfs(nx, ny)
        square_map[x][y] = 0

dfs(1, 1)

print(count)