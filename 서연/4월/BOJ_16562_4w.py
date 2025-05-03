
# 유니온파인드 문제이구만
#  
import sys

# 첫 줄에 학생 수 N (1 ≤ N ≤ 10,000)과 친구관계 수 M (0 ≤ M ≤ 10,000), 가지고 있는 돈 k (1 ≤ k ≤ 10,000,000)
N, M, k = map(int, sys.stdin.readline().split())

# 친구비
f_cost = [0] + list(map(int, sys.stdin.readline().split()))

parent = [i for i in range(N+1)]

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a = find(a)
    b = find(b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

for i in range(M):
    a, b = map(int, input().split())
    union(a, b)

for i in range(1, N + 1):
    find(i)

friend = [0] * (N + 1)

for i in range(1, N + 1):
    temp = find(i)
    if friend[temp] == 0:
        friend[temp] = f_cost[temp]
    else:
        friend[temp] = min(friend[temp], f_cost[i])
    
# 최소비용
answer = sum(friend)

if answer <= k:
    print(answer)
else:
    print("Oh no")