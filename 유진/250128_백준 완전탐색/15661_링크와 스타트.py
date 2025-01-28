import sys
input = sys.stdin.readline

n = int(input())
s = [list(map(int, input().split())) for _ in range(n)]
visited = [False] * n
MIN_STATE =sys.maxsize

def dfs():
    global MIN_STATE
    p1, p2 = 0, 0
    for i in range(n):
        for j in range(n):
            if visited[i] and visited[j]:
                p1 += s[i][j]
            elif not visited[i] and not visited[j]:
                p2 += s[i][j]
    MIN_STATE = min(MIN_STATE, abs(p1 - p2))
    return

def solution(depth):
    if depth == n:
        dfs()
        return
    visited[depth] = True
    solution(depth + 1)
    visited[depth] = False
    solution(depth + 1)

solution(0)
print(MIN_STATE)