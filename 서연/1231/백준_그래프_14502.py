from collections import deque
import copy
import sys

n, m = map(int, sys.stdin.readline().split())
graph = []

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bsf(x, y):
    queue = deque()
    tmp = copy.deepcopy(graph)

    for i in range(n):
        for j in range(m):
            if tmp[i][j] == 2:
                queue.append((i, j))
    
    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if tmp[nx][ny] == 0:
                tmp[nx][ny] = 2
                queue.append((nx, ny))
    
    global result
    cnt = 0

    for i in range(n):
        cnt += tmp[i].count(0)

    result = max(result, cnt)

def wall(cnt):
    if cnt == 3:
        bsf()
        return
    
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 0: 
                graph[i][j] = 1
                wall(cnt + 1)
                graph[i][j] = 0

for _ in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))

answer = 0
wall(0)
print(answer)