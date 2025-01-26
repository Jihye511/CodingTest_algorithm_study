# # 방법 1
# import sys
# from itertools import combinations

# n = int(sys.stdin.readline())
# arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# def check(map_list):
#     global answer
#     # visited로 꽃 잎이 겹치는지 확인
#     visited = []
#     total = 0
#     for x, y in map_list:
#         visited.append((x, y))
#         total += arr[x][y]
#         for i in range(4):
#             nx = x + dx[i]
#             ny = y + dy[i]

#             # 안 겹친다면 total에 더하기
#             if (nx, ny) not in visited:
#                 total += arr[nx][ny]
#                 visited.append((nx, ny))

#             # 겹친다면 바로 끝 return
#             else:
#                 return
#     # 최솟값을 구해야하기 때문에 담기
#     answer = min(answer, total)

# # 위, 아래, 오, 왼
# dx = [0, 0, 1, -1]
# dy = [1, -1, 0, 0]

# result = []
# answer = 1e9

# # 꽃이 안 죽으려면 가장자리는 피해서 심어야 하기 때문에 안쪽 좌표만 result에 담기
# for i in range(1, n-1):
#     for j in range(1, n-1):
#         result.append((i, j))

# # combinations으로 씨앗을 심을 수 있는 좌표 check에 모두 담기
# for i in combinations(result, 3):
#     check(i)

# print(answer)

# # 방법 2
# import sys

# # dfs 방식
# def check(x, y, visited):
#     for i in range(4):
#         nx = x + dx[i]
#         ny = y + dy[i]

#         if (nx, ny) in visited:
#             return False
#     return True

# def dfs(visited, total):
#     global answer
#     if total >= answer: 
#         return
    
#     if len(visited) == 15:
#         answer = min(answer, total)
#     else:
#         for i in range(1, n-1):
#             for j in range(1, n-1):
#                 if check(i, j, visited) and (i, j) not in visited:
#                     temp = [(i, j)]
#                     temp_total = arr[i][j]
#                     for idx in range(4):
#                         nx = i + dx[idx]
#                         ny = j + dy[idx]
#                         temp_total += arr[nx][ny]
#                         temp.append((nx, ny))
#                     dfs(visited + temp, total + temp_total)

# n = int(sys.stdin.readline())
# arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# # 위, 아래, 오, 왼
# dx = [0, 0, 1, -1]
# dy = [1, -1, 0, 0]

# answer = 1e9

# dfs([], 0)

# print(answer)

# 방법 3
import sys

n = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

def check(i, j, visited):
    for dx, dy in (0, 1), (0, -1), (1, 0), (-1, 0), (0, 0):
        x, y = i + dx, j + dy
        if not ((0 <= x < n and 0 <= y < n)) or visited[x][y]:
            return False
    return True

def calc(i, j):
  cost = 0
  for dx, dy in (0, 1), (0, -1), (1, 0), (-1, 0), (0, 0):
    x, y = i + dx, j + dy
    cost += arr[x][y]
  return cost

def dfs(x, cnt, visited, cost_sum):
  global answer
  
  if cnt == 3:
    answer = min(answer, cost_sum)
    return
  
  for i in range(x, n-1):
    for j in range(1, n-1):
      if check(i, j, visited):
        for dx, dy in (0, 1), (0, -1), (1, 0), (-1, 0), (0, 0):
            visited[i + dx][j + dy] = True
        
        dfs(i, cnt+1, visited, cost_sum + calc(i, j))
        
        for dx, dy in (0, 1), (0, -1), (1, 0), (-1, 0), (0, 0):
            visited[i + dx][j + dy] = False

answer = 1e9
dfs(1, 0, [[False for _ in range(n)] for _ in range(n)], 0)

print(answer)
