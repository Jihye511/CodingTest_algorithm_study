import sys
from collections import deque
N, L, R = map(int,input().split())
country = []
dx = [1,-1,0,0]
dy = [0,0,1,-1]
population_flag = True
result = 0

for _ in range(N):
    country.append([int(x) for x in sys.stdin.readline().rstrip().split()])

def bfs(x,y):
    global population_flag
    union_list = []
    union_person = 0
    deq = deque()

    visited[x][y] = True
    union_list.append([x,y])
    union_person += country[x][y]
    deq.append([x,y])

    while deq:
        a,b = deq.popleft()
        for i in range(4):
            nx, ny = a + dx[i], b + dy[i]
            if 0 <= nx < N and 0 <= ny < N and not visited[nx][ny]:
                if L <= abs(country[a][b] - country[nx][ny]) <= R:
                    visited[nx][ny] = True
                    deq.append([nx,ny])
                    union_list.append([nx,ny])
                    union_person += country[nx][ny]

    union_len = len(union_list)

    if union_len >= 2:
        for u in union_list:
            country[u[0]][u[1]] = union_person // union_len
        population_flag = True

def check(x, y):
    for i in range(4):
        nx, ny = x + dx[i], y + dy[i]
        if 0 <= nx < N and 0 <= ny < N:
            if L <= abs(country[x][y] - country[nx][ny]) <= R:
                return 1
    return 0

while population_flag:
    population_flag = False
    visited = [[False] * N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and check(i,j):
                bfs(i,j)

    if population_flag:
        result += 1

print(result)