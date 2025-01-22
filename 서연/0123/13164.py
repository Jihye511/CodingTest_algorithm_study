import sys

n , k = map(int, sys.stdin.readline().split())
children = list(map(int, sys.stdin.readline().split())) # 오름차순

array = []
for i in range(1, n):
    array.append(children[i] - children[i-1])

array.sort()

print(sum(array[:n-k]))