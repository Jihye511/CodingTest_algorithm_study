import sys

input = sys.stdin.readline

INF = int(1e8)



def find(n):
    temp = n
    while n != group[n]:
        n = group[n]
    group[temp] = n
    return n

def union(n1, n2):
    n1 = find(n1)
    n2 = find(n2)
    if n1 > n2:
        n1, n2 = n2, n1
    group[n2] = n1

N = int(input())
group = [i for i in range(N+1)]
edges = []
for i in range(1, N+1):
    W = int(input())
    edges.append((W, 0, i))
for i in range(1, N+1):
    P = tuple(map(int, input().split()))
    for j in range(i+1, N+1):
        edges.append((P[j-1], i, j))
edges.sort()
res = cnt = 0
for p, i, j in edges:
    if find(i) != find(j):
        union(i, j)
        res += p
        cnt += 1
        if cnt >= N:
            break
print(res)

