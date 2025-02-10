import itertools
import sys
from itertools import combinations_with_replacement

N, M = map(int, sys.stdin.readline().split())
arr = list(set(map(int, sys.stdin.readline().split()))) # 미리 중복 제거
arr.sort()

nums = itertools.product(arr, repeat=M)
result = []

if M == 1:
    for i in arr:
        print(i)
else:
    for combination in combinations_with_replacement(arr, M):
        print(*combination)



#else:
#    for p in product(arr, repeat=M):
#        if all(p[i] <= p[i+1] for i in range(M-1)):  # all() 사용하여 조건 체크
#            print(*p)
