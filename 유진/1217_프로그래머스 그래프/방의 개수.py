dx = [0, 1, 1, 1, 0, -1, -1, -1]
dy = [-1, -1, 0, 1, 1, 1, 0, -1]


def solution(arrows):
    answer = 0
    x, y = 0, 0

    edge_set = set()
    coord_set = set([(x, y)])

    for arrow in arrows:
        for _ in range(2):
            ax, ay = x + dx[arrow], y + dy[arrow]

            if (ax, ay) in coord_set and (x, y, ax, ay) not in edge_set:
                answer += 1

            coord_set.add((ax, ay))
            edge_set.add((x, y, ax, ay))
            edge_set.add((ax, ay, x, y))
            x, y = ax, ay

    return answer