import sys

n = int(sys.stdin.readline())
graph = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
visited = [False] * n
result = 1e9

def dfs(start, current, cost, cnt):
    global result
    if cnt == n: # 만약 방문한 도시가 입력받은 도시의 개수라면
        if graph[current][start]: # 마지막 도시에서 출발 도시로 가는 비용이 0이 아니라면 (즉, 갈 수 있다면)
            result = min(result, cost + graph[current][start]) # 더한 값을 저장되어있는 최소값과 비교해서 대입
        return
    
    for i in range(n): # 도시의 개수 만큼 반복문을 돈다.
        # 만약 현재 도시에서 갈 수 있는 도시의 비용이 0이 아니고 이미 방문한 도시가 아니며 그 비용값이 저장되어있는 최소값보다 작다면
        if not visited[i] and graph[current][i] != 0 and cost < result:
            visited[i] = True
            dfs(start, i, cost + graph[current][i], cnt + 1)
            visited[i] = False

for i in range(n):
    visited[i] = True
    dfs(i, i, 0, 1) # start, current, cost, cnt
    visited[i] = False

print(result)