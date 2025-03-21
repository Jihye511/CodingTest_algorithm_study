"""
# 내 풀이 -> 992ms 최악..
import sys
from collections import deque

'''
- bfs로 진행
- 현재 도시에서 다음 도시로 갈 수 있는지를 확인
- 갈 수 없다면 NO 출력하고 종료
- 모든 도시를 방문할 수 있다면 YES 출력
'''

# 입력 받기
n = int(sys.stdin.readline()) # 도시 수
m = int(sys.stdin.readline()) # 여행 계획에 속한 도시 수
maps = [list(map(int, sys.stdin.readline().split())) for _ in range(n)] # 도시 연결 정보
plans = list(map(int, sys.stdin.readline().split())) # 여행 계획
plans = [plans[i]-1 for i in range(m)]

# bfs
# 현재 도시 -> 다음 도시 가능?
def bfs(start, end):
    q = deque([start])
    visited = [False for _ in range(n)]
    visited[start] = True

    while q:
        city = q.popleft()
        for i in range(n):
            if maps[city][i] and not visited[i]:
                visited[i] = True
                q.append(i)
    return visited[end]

# 여행 계획 확인
for i in range(m-1):
    # 갈 수 없는 경우에 NO 출력하고 종료
    if not bfs(plans[i], plans[i+1]):
        print('NO')
        break

else:
    print('YES')
"""

"""
'''
- 인터넷 풀이 참고 -> 60ms
- bfs로 풀이
- 첫 도시를 시작으로해서 방문할 수 있는 모든 도시를 visit에 저장
- 여행 계회에 있는 도시를 방문했는지 확인
- 방문하지 않은 도시가 있다면 NO 출력하고 break
- 모든 도시를 방문했다면 YES 출력

- 내가 잘못생각한 부분
-- bfs로 풀이할 때, 현재 도시에서 다음 도시로 갈 수 있는지 확인하는 것이 아니라 현재 도시에서 방문할 수 있는 모든 도시를 확인해야함
'''
import sys
from collections import deque

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
maps = [list(map(int, sys.stdin.readline().split())) for _ in range(n)] # 도시 연결 정보
plans = list(map(int, sys.stdin.readline().split())) # 여행 계획

def bfs(maps, start, visit):
    q = deque([start])
    visit[start] = 1
    
    while q:
        node = q.popleft()

        for idx, item in enumerate(maps[node]):
            if item and visit[idx] == 0:
                visit[idx] = 1
                q.append(idx)

visit = [0] * n
bfs(maps, plans[0]-1, visit)

flag = True
for item in plans:
    if visit[item-1] == 0:
        flag = False
        break

if flag:
    print('YES')
else:
    print('NO')
"""

# union-find로 풀이 -> 44ms
import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

maps = [[0] * (n + 1)]
for _ in range(n):
    maps.append([0] + list(map(int, sys.stdin.readline().split())))

plans = list(map(int, sys.stdin.readline().split()))

num = [i for i in range(n + 1)]

def union(i, j):
    if (find(i) != find(j)):
        num[find(j)] = find(i)

def find(i):
    if (i == num[i]):
        return i
    else:
        num[i] = find(num[i])
        return num[i]

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if maps[i][j] == 1:
            union(i, j)

check = True
for i in range(1, m):
    if (find(plans[0]) != find(plans[i])):
        check = False
        break

if (check):
    print('YES')
else:
    print('NO')