import sys

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)

n, w = map(int, input().split())
edges = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    u, v = map(int, input().split())
    edges[u].append(v)
    edges[v].append(u)

visited = [False] * (n + 1)


def dfs(now):
    v = False
    leaves = 0
    for nx in edges[now]:
        if not visited[nx]:
            visited[nx] = True
            leaves += dfs(nx)
            visited[nx] = False
            v = True
    if not v:
        leaves = 1
    return leaves


visited[1] = True
print(w / dfs(1))