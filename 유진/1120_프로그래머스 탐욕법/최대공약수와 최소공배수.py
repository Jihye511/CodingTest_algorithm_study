def solution(n, m):
    yak = []
    result = []

    # 최대공약수
    for i in range(1, min(n, m) + 1):
        if n % i == 0 and m % i == 0:
            yak.append(i)
    result.append(max(yak))

    #최소 공배수
    for i in range(min(n, m), n * m + 1, min(n, m)):
        if i % n == 0 and i % m == 0:
            result.append(i)
            break

    return result