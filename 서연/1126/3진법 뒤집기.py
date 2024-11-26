def solution(n):
    answer = 0

    t = ''
    while n != 0:
        t += str(n % 3)
        n //= 3

    tlen = len(t)

    for i in range(len(t)):
        answer += (3 ** i) * int(t[len(t) - i - 1])

    # answer = int(t, 3)

    return answer
