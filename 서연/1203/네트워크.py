from collections import deque

def solution(n, computers):
    answer = 0
    visited = [0] * n
    q = deque([])

    while 0 in visited:
        answer += 1
        novisited = visited.index(0)
        visited[novisited] = 1
        q.append(novisited)
        while q:
            v = q.popleft()
            for idx, i in enumerate(computers[v]):
                if i == 1 and visited[idx] == 0:
                    q.append(idx)
                    visited[idx] = 1
    return answer