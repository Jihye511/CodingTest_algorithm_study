# # 14889번이랑 비슷함
# # pyp3로 해야 시간초과 안남

# # 방법 1
# import sys
# from itertools import combinations

# n = int(sys.stdin.readline())
# scores = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

# combi = []
# for num in range(1, n):
#     for i in combinations(list(range(n)), num):
#         combi.append(i)

# combi_len = len(combi)

# result = 1e9

# for i in range(combi_len//2):
#     start_team = combi[i]
#     link_team = combi[-i-1]

#     start_score = 0
#     link_score = 0

#     start_team_combi = list(combinations(start_team, 2))
#     link_team_combi = list(combinations(link_team, 2))

#     for x, y in start_team_combi:
#         start_score += scores[x][y] + scores[y][x]
    
#     for x, y in link_team_combi:
#         link_score += scores[x][y] + scores[y][x]

#     result = min(result, abs(start_score - link_score))

#     if result == 0:
#         break

# print(result)

# 방법 2 - 훨씬 빠름
import sys

n = int(sys.stdin.readline())
scores = [list(map(int,sys.stdin.readline().split(" "))) for _ in range(n)]

result = 1e9

for i in range(1, 2**(n-1)):
    leejinsu = format(i,'b').zfill(n)
    # print(leejinsu)

    start,link= [], [] #0은 스타트 1은 링크
    start_score = 0
    link_score = 0

    for idx, i in enumerate(leejinsu):
        # print(idx, i)
        if i == "0":
            start.append(idx)
        else:
            link.append(idx)
    # print(start, link)

    if len(start) >= 2:
        for j in range(len(start)):
            for k in range(j+1, len(start)):
                start_score += scores[start[j]][start[k]] + scores[start[k]][start[j]]
    
    if len(link) >= 2:
        for j in range(len(link)):
            for k in range(j+1, len(link)):
                link_score += scores[link[j]][link[k]] + scores[link[k]][link[j]]
    
    result = min(result, abs(start_score - link_score))

    if result == 0:
        break

print(result)