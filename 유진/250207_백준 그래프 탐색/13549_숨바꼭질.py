from collections import deque
import sys
input = sys.stdin.readline

def bfs(i,j):
    q = deque([i])
    visited[i] = 1
    while q:
        x = q.popleft()
        if x == j:
            return
        # !!NOTE!! 2*x, x-1, x+1  순서로 해야함, 그러지 않으면 틀림
        for nx in (2*x, x-1, x+1):
            if nx < 0 or nx > MAX:
                continue
            if visited[nx]:
                continue

            if nx == 2*x:
                visited[nx] = visited[x]
            else:
                visited[nx] = visited[x] + 1

            q.append(nx)


N, K = map(int, input().split())
MAX = 10**5
visited = [0] * (MAX+1)
bfs(N,K)
print(visited[K]-1)