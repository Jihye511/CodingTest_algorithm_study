import sys
from collections import deque

N, K = map(int, sys.stdin.readline().split())


d = deque()

d.append(N)
visited = [-1] * 100001   # 각 위치까지 도달하는데 걸리는 시간
visited[N] = 0            # 시작점 = 0


while d:
    x = d.popleft()

    if x == K:
        print(visited[x])
        break

    for i in [x-1, x+1, x*2]:
        if 0 <= i <= 100000 and visited[i] == -1:
            visited[i] = visited[x] + 1
            d.append(i)