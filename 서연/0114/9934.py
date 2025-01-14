import sys

def sol(start, end , level):
    if start == end:
        result[level].append(lst[start])
        return
    center = (start + end) // 2
    result[level].append(lst[center])
    
    sol(start, center - 1, level + 1)
    sol(center + 1, end, level + 1)


k = int(sys.stdin.readline())
lst = list(map(int, sys.stdin.readline().split()))
l = len(lst)

result = [[] for _ in range(k)]

sol(0, l - 1, 0)

for r in result:
    print(*r)
