import sys
from collections import deque

N = int(sys.stdin.readline())

graph = [[] for _ in range(N + 1)]

for i in range(N - 1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (N + 1)


def bfs(start):
    queue = deque([start])
    visited[start] = start

    while queue:  # 큐가 빌 때까지 반복
        v = queue.popleft()  # 큐에서 노드를 하나 꺼냄

        for i in graph[v]:  # 현재 노드와 연결된 모든 노드 확인
            if visited[i] == 0:  # 아직 방문하지 않은 노드라면
                visited[i] = v  # 현재 노드를 부모로 저장
                queue.append(i)  # 큐에 추가


# BFS 실행 (1번 노드가 루트)
bfs(1)

# 결과 출력 (2번 노드부터 순서대로 부모 노드 출력)
for i in range(2, N + 1):
    print(visited[i])