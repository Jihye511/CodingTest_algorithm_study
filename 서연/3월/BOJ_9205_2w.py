import sys
from collections import deque

def bfs():
    q = deque([(h_x, h_y)]) #시작점을 큐에 담아준다
    print(q)

    while q:
        x, y = q.popleft()
        if abs(x - f_x) + abs(y - f_y) <= 1000:
            print('happy')
            return
        
        for i in range(n):
            if not visited[i]: # 방문하지 않은 편의점 확인
                new_x, new_y = stores[i]
                if abs(x - new_x) + abs(y - new_y) <= 1000:
                    visited[i] = True
                    q.append((new_x, new_y))
    print('sad')
    return

t = int(sys.stdin.readline())

for _ in range(t):

    # 편의점 개수
    n = int(sys.stdin.readline())

    # 집 좌표
    h_x, h_y = map(int,sys.stdin.readline().split())

    stores = []
    # 편의점 좌표
    if n != 0:
        stores = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    
    # 페스티벌 좌표
    f_x, f_y = map(int,sys.stdin.readline().split())
    
    visited = [False for _ in range(n+1)]
    
    # 실행
    bfs()