'''
import 부분
'''
import sys
from collections import deque

'''
함수 정의 부분
'''
q = deque()
# bfs_search: 현재 나라에서 인구 이동이 가능한 나라를 탐색하는 함수
def bfs_search(x, y):
    q.append((x, y)) # 탐색할 나라
    union = [(x, y)] # 국경을 연 나라들을 저장하는 리스트

    while q:
        a, b = q.popleft()
        
        for i in range(4):
            na, nb = a + dx[i], b + dy[i]

            # 범위를 벗어나지 않고, 국경을 열지 않았다면
            if 0 <= na < N and 0 <= nb < N and not opened[na][nb]:

                # 인구 이동이 가능한 차이라면
                if L <= abs(people[a][b]-people[na][nb]) <= R:
                    opened[na][nb] = True
                    q.append((na,nb))
                    union.append((na,nb))

    if len(union) == 1: # 국경을 연 나라가 1개라면 인구 이동이 불가능함
        return False
    
    # 인구 이동
    new_population = sum(people[a][b] for a, b in union) // len(union)
    for a, b in union:
        people[a][b] = new_population
    return True # 인구 이동 성공 return

'''
시작 부분
'''
# 1. 입력 받기
N, L, R = map(int, sys.stdin.readline().split())
people = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]
result = 0 # 이동한 날의 수

while True:
    moved = False # 인구 이동 발생 여부
    opened = [[False]*N for _ in range(N)] # 열렸는지 여부를 저장하는 리스트
    
    # 2. 현재 상황에서 국경을 열 수 있는 나라를 탐색
    for i in range(N):
        for j in range(N):
            if not opened[i][j]: # 탐색하지 않았으면
                opened[i][j] = True # 탐색했다고 표시한 후에
                
                if bfs_search(i, j): # 탐색하기
                    moved = True

    if not moved:
        print(result)
        break

    result += 1