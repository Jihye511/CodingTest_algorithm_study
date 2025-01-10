import sys

a, b = map(int, sys.stdin.readline().split())

primeList = [True] * (int(b ** 0.5) + 1)
primeList[0], primeList[1] = False, False

# 소수인가? - 에라토스테네스의 체
for i in range(2, int(b ** 0.5) + 1):
    if primeList[i]:
        if i ** 2 > int(b ** 0.5):
            break
        for j in range(i ** 2, int(b ** 0.5) + 1, i):
            primeList[j] = False

count = 0
for i in range(1, len(primeList)):
    if primeList[i]:
        res = i ** 2
        while res <= b:
            if res >= a:
                count += 1
            res *= i

print(count)