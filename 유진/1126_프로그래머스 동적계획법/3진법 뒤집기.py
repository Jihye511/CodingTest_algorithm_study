def solution(n):
    answer = ''

    # 3진법 반전
    while n >= 1:
        n, rest = divmod(n, 3)
        answer += str(rest)

    # 3진법 > 10진법
    answer = int(answer, 3)

    return answer
