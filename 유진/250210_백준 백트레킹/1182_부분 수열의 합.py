import sys
from itertools import combinations

N, S = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

count = 0
for i in range(1, N+1):
    for combo in combinations(arr, i):
        if sum(combo) == S:
            count += 1
print(count)