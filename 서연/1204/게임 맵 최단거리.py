from collections import deque

def solution(maps):
    answer = 0

    # 좌상우하
    dx = [-1, 0, 1, 0]
    dy = [0, 1, 0, -1]

    n = len(maps)
    m = len(maps[0])

    q = deque()
    q.append((0, 0))

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx <= n - 1 and 0 <= ny <= m - 1:  # 이동한 위치가 맵을 벗어나지 않고
                if maps[nx][ny] == 1:  # 이동한 위치가 벽이 아니고 지나가지 않은 길인 경우
                    maps[nx][ny] = maps[x][y] + 1
                    q.append((nx, ny))

    answer = -1 if maps[n - 1][m - 1] == 1 else maps[n - 1][m - 1]

    return answer