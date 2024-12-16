def solution(n, results):
    answer = 0
    win = [set() for i in range(n + 1)]  # i가 이긴 경우, 상대 선수
    lose = [set() for i in range(n + 1)]  # i가 진 경우, 상대 선수

    for a, b in results:   # a가 b를 이김
        win[a].add(b)
        lose[b].add(a)

    for idx in range(1, n + 1):
        for x in win[idx]:
            lose[x].update(lose[idx])
        for x in lose[idx]:
            win[x].update(win[idx])

    for player in range(1, n + 1):
        count = len(win[player]) + len(lose[player])
        if count == n - 1:
            answer += 1

    return answer