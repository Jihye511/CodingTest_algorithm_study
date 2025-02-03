import sys

R, C, N = map(int, sys.stdin.readline().split()) # R:행, C:열, N:초

initial = [list(sys.stdin.readline().strip()) for _ in range(R)]


def bomb(graph):
    current = [['O' for _ in range(C)] for _ in range(R)]

    for i in range(R):
        for j in range(C):
            if graph[i][j] == 'O':
                current[i][j] = '.'

                for dx, dy in (0, 1), (0, -1), (-1, 0), (1, 0):
                    x, y = i + dx, j + dy

                    if 0 <= x < R and 0 <= y < C:
                        current[x][y] = '.'

    return current


if N == 1:    # 초기 상태
    for i in range(R):
        for j in range(C):
            print(initial[i][j], end='')
        print()


elif N % 2 == 0:  # 모든 폭탄이 심어졌을 때
    for i in range(R):
        print('O' * C)


# 3, 7, 11 , ,,, 초 후 폭탄이 터질 때 = 초기상태의 폭탄이 터질 때
elif N % 4 == 3:
    result = bomb(initial)
    for i in range(R):
        print("".join(result[i]))

# 5, 9, 13 , ,,, 초 후 폭탄이 터질 때
elif N % 4 == 1:
    result = bomb(bomb(initial))
    for i in range(R):
        print("".join(result[i]))
