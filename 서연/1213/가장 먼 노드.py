from collections import deque, Counter

def solution(n, edge):
    answer = 0

    arr = [[] for _ in range(n + 1)]

    min_dist = [-1] * (n + 1)

    for a, b in edge:
        arr[a].append(b)
        arr[b].append(a)

    # print(arr) # [[], [3, 2], [3, 1, 4, 5], [6, 4, 2, 1], [3, 2], [2], [3]]

    q = deque([1])  # 1에서 출발
    min_dist[1] = 0

    while q:
        v = q.popleft()

        for i in arr[v]:
            if min_dist[i] == -1:  # 아직 방문하지 않았은 노드라면
                min_dist[i] = min_dist[v] + 1
                q.append(i)

    # print(min_dist)

    # print(Counter(min_dist)[max(min_dist)])
    answer = Counter(min_dist)[max(min_dist)]

    return answer