import sys
from itertools import combinations

n = int(sys.stdin.readline())

arr = []
answer = 1e9

for _ in range(n):
    s, b = map(int, sys.stdin.readline().split())
    arr.append((s, b))

for i in range(1, n+1):
    for comb in combinations(list(range(n)), i):
        s, b = 1, 0

        for c in comb:
            s *= arr[c][0]
            b += arr[c][1]

        if abs(s - b) < answer:
            answer = abs(s - b)

print(answer)