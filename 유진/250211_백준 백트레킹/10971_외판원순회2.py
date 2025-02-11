import sys

input = sys.stdin.readline
n = int(input())
costs = [list(map(int, input().split())) for _ in range(n)]
visited = [0] * n  # 방문했는지 안했는지
sum_cost = 0  # 방문비용 합
ans = sys.maxsize


def dfs(depth, x):
    global sum_cost, ans
    if depth == n - 1: # 종료 조건
        if costs[x][0]:
            sum_cost += costs[x][0]
            if sum_cost < ans: # 최소값 비교
                ans = sum_cost
            sum_cost -= costs[x][0]
        return
    for i in range(1, n):
        if visited[i] == 0 and costs[x][i]: # 방문 안한 도시 일떄
            visited[i] = 1 # 방문 체크
            sum_cost += costs[x][i] # 방문 비용 합치기
            dfs(depth + 1, i) # 재귀
            visited[i] = 0 # 재귀가 끝나면 초기화
            sum_cost -= costs[x][i] # 재귀가 끝나면 초기화


dfs(0, 0)
print(ans)
