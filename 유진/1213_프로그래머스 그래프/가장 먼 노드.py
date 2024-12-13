from collections import deque


def solution(n, edge):
    answer = 0
    # 연결된 노드 정보 그래프
    graph = [[] for _ in range(n + 1)]
    # 각 노드의 최단거리 리스트
    distance = [-1] * (n + 1)

    # 연결된 노드 정보 추가
    for e in edge:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])

    queue = deque([1])  # BFS를 위한 queue, 출발 노드 = 1
    distance[1] = 0  # 출발노드의 최단거리를 0으로

    # BFS 수행
    while queue:
        now = queue.popleft()  # 현재 노드

        # 현재 노드에서 이동할 수 있는 모든 노드 확인
        for i in graph[now]:
            if distance[i] == -1:  # 아직 방문하지 않은 노드면,
                queue.append(i)  # queue에 추가
                distance[i] = distance[now] + 1  # 최단거리 갱신
    # 가장 멀리 떨어진 노드 개수 구하기
    for d in distance:
        if d == max(distance):
            answer += 1
    return answer


