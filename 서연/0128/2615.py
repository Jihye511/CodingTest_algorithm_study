import sys

# 검1, 흰2, 없음0
maps = [list(map(int, sys.stdin.readline().split())) for _ in range(19)]

# → ↓ ↘ ↗
dx = [0, 1, 1, -1]
dy = [1, 0, 1, 1]

for x in range(19):
    for y in range(19):
        if maps[x][y] != 0: # 바둑알이 있다면
            focus = maps[x][y] # 바둑알 색 저장

            for i in range(4):
                cnt = 1
                nx = x + dx[i]
                ny = y + dy[i]

                while 0 <= nx < 19 and 0 <= ny < 19 and maps[nx][ny] == focus: # 판 안에 있고, 같은 색이면
                    cnt += 1

                    if cnt == 5:
                        # 육목 체크
                        if 0 <= x - dx[i] < 19 and 0 <= y - dy[i] < 19 and maps[x - dx[i]][y - dy[i]] == focus:
                            break
                        if 0 <= nx + dx[i] < 19 and 0 <= ny + dy[i] < 19 and maps[nx + dx[i]][ny + dy[i]] == focus:
                            break
                        # 육목이 아니면 성공한거니까 종료
                        print(focus)
                        print(x + 1, y + 1)
                        sys.exit(0)

                    nx += dx[i]
                    ny += dy[i]

print(0)
