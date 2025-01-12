import sys
sys.setrecursionlimit(10**6)
n = int(sys.stdin.readline())

graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)

result = [0] * (n+1)

for _ in range(n-1):
    a, b = map(int, sys.stdin.readline().split())

    graph[a].append(b)
    graph[b].append(a)

# print(graph) # [[], [6, 4], [4], [6, 5], [1, 2, 7], [3], [1, 3], [4]]

def dfs(graph, start, visited):
    visited[start] = True

    for i in graph[start]:
        if not visited[i]:
            result[i] = start
            dfs(graph, i, visited)

dfs(graph, 1, visited)

# print(result[2:])

print('\n'.join(map(str, result[2:])))