# 유니온파인드~

import sys

n = int(sys.stdin.readline())

arr = [] # [start, end, cost]

for i in range(1, n + 1):
    arr.append([0, i, int(sys.stdin.readline())])

for i in range(n):
    tmp = list(map(int, sys.stdin.readline().split()))
    
    for j in range(n):
        if i != j:
            arr.append([i + 1, j + 1, tmp[j]])

# print(arr)

# 비용으로 정렬
arr.sort(key = lambda x : x[2])

parent = [i for i in range(n + 1)]

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

result = 0
for u, v, w in arr:
    u_p = find(u)
    v_p = find(v)

    if u_p != v_p:
        union(u_p, v_p)
        result += w
        
print(result)
    