import sys
from itertools import combinations

input = list(sys.stdin.readline().strip())
open = []
pair = []

# 괄호의 쌍 찾기 - 인덱스 값
for i in range(len(input)):
    if input[i] == '(':
        open.append(i)
    elif input[i] == ')':
        pair.append([open.pop(), i])

# print(pair)

result = []
for cnt in range(1, len(pair)+1):
    for comb in combinations(pair, cnt):
        # print(comb)
        temp = input.copy()
        for i, j in comb:
            temp[i] = ''
            temp[j] = ''
        result.append(''.join(temp))

# 중복 제거
result = list(set(result))

# 사전 순 정렬
result.sort()
for r in result:
    print(r)
