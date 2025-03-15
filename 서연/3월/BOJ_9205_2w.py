import sys
from collections import deque

def bfs():
    q = deque([(h_x, h_y)]) #시작점을 큐에 담아준다

    while q:
        # 1)
        x, y = q.popleft()
        if abs(x - f_x) + abs(y - f_y) <= 1000:
            print('happy')
            return
        
        # 2)        
        for i in range(n):
            if not visited[i]: # 방문하지 않은 편의점 확인
                # 2-1)
                new_x, new_y = stores[i]
                if abs(x - new_x) + abs(y - new_y) <= 1000:
                    visited[i] = True
                    q.append((new_x, new_y))
    
    # 2-2)
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
    
    visited = [False for _ in range(n)] # 편의점 방문 확인
    
    # 실행
    bfs()


'''
풀이
- 한 번에 이동할 수 있는 최대 거리는 1000m
- 편의점에서 최대 구매할 수 있는 맥주는 20개

- 처음에는 편의점을 다 들려야한다고 생각했는데 그럴 필요가 없었음!
-- 그래서 bfs로 확인하는 것이 더 좋음

1. 지금 위치에서 페스티벌 장소까지 거리가 1000m 이내이면 무조건 happy
2. 그렇지 않다면 갈 수 있는 편의점(1000m이내 편의점)이 있는지 확인해야 함
2-1. 있다면 그 편의점으로 이동하고 큐에 넣어줌
2-2. 없다면 sad
'''