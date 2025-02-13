# # 방법 1 조합
# import sys
# from itertools import combinations

# n = int(sys.stdin.readline())

# result = []
# for i in range(1, 11):
#     for comb in combinations(range(0, 10), i):
#         comb = list(comb)
#         comb.sort(reverse=True)
#         result.append(int("".join(map(str, comb))))

# result.sort()   # 오름차순

# try:
#     print(result[n-1])
# except:     # 인덱스가 넘어가는 경우 -1 출력
#     print(-1)

# 방법 2 백트래킹
import sys

n = int(sys.stdin.readline())

arr = []
result = set()

def dfs():
    if len(arr) > 0:
        result.add(int("".join(map(str, arr))))

    for i in range(10):
        if len(arr) == 0 or arr[-1] > i:  # 마지막 값이 더 큰 경우
            arr.append(i)
            dfs()
            arr.pop()

try:
    dfs()
    result = list(result)
    result.sort()
    print(result[n-1])
except:
    print(-1)