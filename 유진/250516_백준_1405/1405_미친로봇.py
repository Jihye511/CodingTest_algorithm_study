import sys

input = sys.stdin.readline

N, e, w, n, s = map(int, input().split())
visited = [[False for _ in range(31)] for _ in range(31)]

direct = [e, w, n, s]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
probability = float(0)


def dfs(depth, prob, row, col):
    global probability

    if depth >= N:
        probability += prob
        return

    for i in range(4):
        nrow, ncol = row + dx[i], col + dy[i]
        if not visited[nrow][ncol] and direct[i] != 0:
            visited[nrow][ncol] = True
            dfs(depth + 1, prob * direct[i] / 100, nrow, ncol)
            visited[nrow][ncol] = False


visited[15][15] = True
dfs(0, 1, 15, 15)
print(probability)
