## 방법 1
# import sys
# from itertools import combinations, permutations
#
# n = int(sys.stdin.readline())
#
# arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
#
# combi_list = list(combinations(list(range(n)), n//2))
# combi_list_length = len(combi_list)
#
# # print(list(combinations(list(range(n)), n//2)))
#
# result = 1e9
# for i in range(combi_list_length//2): # 0 ~ 10
#     start_team = combi_list[i]
#     link_team = combi_list[combi_list_length-i-1]
#
#     # print(i, combi_list_length-i-1)
#     # print(start_team, link_team)
#
#     start_team_score = 0
#     for a, b in list(combinations(start_team, 2)):
#         start_team_score += arr[a][b] + arr[b][a]
#
#     link_team_score = 0
#     for a, b in list(combinations(link_team, 2)):
#         link_team_score += arr[a][b] + arr[b][a]
#
#     # print(start_team_score, link_team_score)
#
#     gap = abs(start_team_score - link_team_score)
#
#     if gap < result:
#         result = gap
#
# print(result)

# 방법 2
import sys

N = int(sys.stdin.readline())
board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
visited = [False for _ in range(N)]
res = 1e9

# DFS
def DFS(L, idx):
    global res
    if L == N // 2:
        A = 0
        B = 0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]:
                    A += board[i][j]
                elif not visited[i] and not visited[j]:
                    B += board[i][j]
        res = min(res, abs(A - B))
        return
    for i in range(idx, N):
        if not visited[i]:
            visited[i] = True
            DFS(L + 1, i + 1)
            visited[i] = False

DFS(0, 0)
print(res)