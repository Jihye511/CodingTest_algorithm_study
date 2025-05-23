import sys
from collections import deque
def input(): return sys.stdin.readline().rstrip()

def bfs(s_y, s_x, s_d):
    visited[s_y][s_x][s_d] = 1
    q = deque([(s_y,s_x,s_d,0)])
    while q:
        y, x, d, cnt = q.popleft()
        if (y, x, d) == (a_y, a_x, a_d): return cnt
        for step in range(1,4):
            dy, dx = y + my[d] * step, x + mx[d] * step
            if 0 > dy or dy >= n or 0 > dx or dx >= m or matrix[dy][dx]: break # 가고 있는 방향에 궤도가 하나라도 없으면 더 멀리 이동할 수 없다.
            if not visited[dy][dx][d]:
                visited[dy][dx][d] = 1
                q.append((dy,dx,d,cnt+1))
        for r_d in rotate[d]:
            if not visited[y][x][r_d]:
                visited[y][x][r_d] = 1
                q.append((y,x,r_d,cnt+1))
    return -1

n, m = map(int,input().split())
matrix = [list(map(int,input().split())) for _ in range(n)]
visited = [[[0]*4 for _ in range(m)] for _ in range(n)]

my = [0,0,1,-1]
mx = [1,-1,0,0]
rotate = {0:[2,3], 1:[2,3], 2:[0,1], 3:[0,1]}

s_y, s_x, s_d = map(lambda x: int(x)-1, input().split())
a_y, a_x, a_d = map(lambda x: int(x)-1, input().split())

print(bfs(s_y, s_x, s_d))