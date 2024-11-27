def solution(m, n, puddles):
    arr = [[0] * (m + 1) for _ in range(n + 1)]
    arr[1][1] = 1
    # print(arr) # [[0, 0, 0, 0, 0], [0, 1, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]]

    for i in range(1, m + 1):  # 1, 2, 3, 4
        for j in range(1, n + 1):  # 1, 2, 3

            if [i, j] in puddles:
                continue

            a = arr[j][i - 1]
            b = arr[j - 1][i]

            if [i - 1, j] in puddles:
                a = 0
            if [i, j - 1] in puddles:
                b = 0
            arr[j][i] += a + b

    # print(arr)
    return arr[-1][-1] % 1000000007