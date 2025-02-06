# import sys
# from collections import deque
#
# n, l, r = map(int, sys.stdin.readline().split())
# people = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
#
# dx = [0, 0, 1, -1]
# dy = [1, -1, 0, 0]
#
# q = deque()
# def bfs(x, y):
#     q.append((x, y))
#     union = [(x, y)]
#
#     while q:
#         a, b = q.popleft()
#
#         for i in range(4):
#             na, nb = a + dx[i], b + dy[i]
#
#             if 0 <= na < n and 0 <= nb < n and not visited[na][nb]:
#                 if l <= abs(people[a][b]-people[na][nb]) <= r:
#                     visited[na][nb] = True
#                     q.append((na,nb))
#                     union.append((na,nb))
#
#     if len(union) <= 1:
#         return False
#
#     result = sum(people[a][b] for a,b in union) // len(union)
#     for a,b in union:
#         people[a][b] = result
#     return True
#
# day = 0
# while True:
#     go = False
#     visited = [[False]*n for _ in range(n)] # 방문했는지 체크
#     for i in range(n):
#         for j in range(n):
#             if not visited[i][j]: # 방문하지 않았으면
#                 visited[i][j] = True # 방문하고, 방문했다고 표시
#                 go += bfs(i, j)
#
#     if not go:
#         break
#
#     day += 1
#
# print(day)


import sys
sys.setrecursionlimit(10000)
n,l,r = map(int,input().split())
people = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

#국경선을 열지말지 결정하는 함수
def dfs(a,b):
    visitied[a][b] = True

    for i in range(4):
        na, nb = a + dx[i], b + dy[i]

        if 0 <= na < n and 0 <= nb <n and not visitied[na][nb]:
            if l <= (abs(people[na][nb] - people[a][b])) <= r:
                union.append((na,nb))
                dfs(na,nb)

    #국경선을 연후 인구이동
    return union

day = 0
while True:
    visitied = [[False]*n for _ in range(n)]
    go = False
    for i in range(n):
        for j in range(n):
            union = [(i,j)]
            if not visitied[i][j]:
                union = dfs(i,j)

            if len(union) > 1:
                go = True
                avg = sum(people[a][b] for a,b in union) // len(union)
                for a,b in union:
                    people[a][b] = int(avg)

    if not go:
        print(day)
        break

    day+=1