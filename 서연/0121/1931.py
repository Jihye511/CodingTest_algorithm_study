import sys

n = int(sys.stdin.readline())

arr = []
for _ in range(n):
    s, e = map(int, sys.stdin.readline().split())
    arr.append((s, e))

# 일찍 끝나는 순서대로 정렬
arr.sort(key=lambda x: (x[1], x[0]))
# print(arr)
# [(1, 4), (3, 5), (0, 6), (5, 7), (3, 8), (5, 9), (6, 10), (8, 11), (8, 12), (2, 13), (12, 14)]

result = 0
endPoint = 0

for s, e in arr:
    if endPoint <= s:
        result += 1
        endPoint = e

print(result)