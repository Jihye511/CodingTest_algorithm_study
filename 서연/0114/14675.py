import sys

n = int(sys.stdin.readline())

graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

# print(graph) # [], [2], [1, 3], [2, 4], [3, 5], [4]]

q = int(sys.stdin.readline())

for _ in range(q):
    t, k = map(int, sys.stdin.readline().split())

    # t가 1일 때는 k번 정점이 단절점인지에 대한 질의
    if t == 1:
        if len(graph[k]) > 1:
            print('yes')
        else:
            print('no')
        
    # t가 2일 때는 입력에서 주어지는 k번째 간선이 단절선인지에 대한 질의
    elif t == 2:
        print('yes')

