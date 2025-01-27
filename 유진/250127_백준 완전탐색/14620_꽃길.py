from itertools import combinations

def check(map_list):
    global answer
    # visited로 꽃 잎이 겹치는지 확인
    visited = []
    total = 0
    for x, y in map_list:
        visited.append((x, y))
        total += maps[x][y]
        for i in range(4):
            ax = x + dx[i]
            ay = y + dy[i]

            # 안 겹친다면 total에 더하기
            if (ax, ay) not in visited:
                total += maps[ax][ay]
                visited.append((ax, ay))

            # 겹친다면 바로 끝 return
            else:
                return
    # 최솟값을 구해야하기 때문에 담기
    answer = min(answer, total)




n = int(input())
# 상하좌우
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
result = []
maps = []
answer = int(1e9)

for _ in range(n):
    maps.append(list(map(int, input().split())))

# 꽃이 안 죽으려면 가장자리는 피해서 심어야 하기 때문에 안쪽 좌표만 result에 담기
for i in range(1, n - 1):
    for j in range(1, n - 1):
        result.append((i, j))

# combinations으로 씨앗을 심을 수 있는 좌표 check에 모두 담기
for i in combinations(result, 3):
    check(i)

print(answer)
