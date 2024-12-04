def dfs(start, computers, visited, n):
    for i in range(n):
        if computers[start][i] and not visited[i]:
            visited[i] = 1
            dfs(i, computers, visited, n)

def solution(n, computers):
    answer = 0
    visited = [0] * n
    for i in range(n):
        if visited[i]:
            continue
        visited[i] = 1
        dfs(i, computers, visited, n)
        answer += 1
    return answer