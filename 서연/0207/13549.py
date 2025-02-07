import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())

q = deque([n])
visited = [-1 for _ in range(100001)]
visited[n] = 0

while q:
    v = q.popleft()

    if v == k:
        print(visited[v])
        break

    for i in [v-1, v+1, v*2]:
        if i == 2*v:
            if 0 <= i < 100001 and visited[i] == -1:
                visited[i] = visited[v]
                q.appendleft(i)
        else:
            if 0 <= i < 100001 and visited[i] == -1:
                visited[i] = visited[v] + 1
                q.append(i)