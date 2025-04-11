import sys

n = int(sys.stdin.readline())
maps = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

'''
dfs로 풀었을 때 python은 시간초과...
PyPy3는 통과...ㅠ
'''
# 0: 가로, 1: 세로, 2: 대각선
def dfs(x, y, d):
    if x == n - 1 and y == n - 1:
        return 1

    cnt = 0
    if d == 0:  # 가로
        if y + 1 < n and maps[x][y + 1] == 0:
            cnt += dfs(x, y + 1, 0)
        if x + 1 < n and y + 1 < n and maps[x][y + 1] == 0 and maps[x + 1][y] == 0 and maps[x + 1][y + 1] == 0:
            cnt += dfs(x + 1, y + 1, 2)
    
    elif d == 1:  # 세로
        if x + 1 < n and maps[x + 1][y] == 0:
            cnt += dfs(x + 1, y, 1)
        if x + 1 < n and y + 1 < n and maps[x][y + 1] == 0 and maps[x + 1][y] == 0 and maps[x + 1][y + 1] == 0:
            cnt += dfs(x + 1, y + 1, 2)
    
    else:   # 대각선
        if y + 1 < n and maps[x][y + 1] == 0:
            cnt += dfs(x, y + 1, 0)
        if x + 1 < n and maps[x + 1][y] == 0:
            cnt += dfs(x + 1, y, 1)
        if x + 1 < n and y + 1 < n and maps[x][y + 1] == 0 and maps[x + 1][y] == 0 and maps[x + 1][y + 1] == 0:
            cnt += dfs(x + 1, y + 1, d)

    return cnt

# print(dfs(0, 1, 0))

'''
dp[0][row][col] 가로에 대한 dp
dp[1][row][col] 세로에 대한 dp
dp[2][row][col] 대각선에 대한 dp
'''
dp = [[[0 for _ in range(n)] for _ in range(n)] for _ in range(3)]

dp[0][0][1] = 1 # 가로 방향으로 (0, 1)에 파이프가 놓여있음

# 첫 번째 행은 가로 방향으로만 파이프를 놓을 수 있음
for i in range(2, n):
    if maps[0][i] == 0:
        dp[0][0][i] = dp[0][0][i - 1]
# print(dp)

for i in range(1, n):
    for j in range(1, n):
        if maps[i][j] == 0 and maps[i][j - 1] == 0 and maps[i - 1][j] == 0:
            # 대각선 파이프: 가로 방향에서 오는 경우 + 세로 방향에서 오는 경우 + 대각선 방향에서 오는 경우
            dp[2][i][j] = dp[0][i - 1][j - 1] + dp[1][i - 1][j - 1] + dp[2][i - 1][j - 1]

        if maps[i][j] == 0:
            # 가로 파이프: 가로방향에서 오는 경우 + 대각선 방향에서 오는 경우
            dp[0][i][j] = dp[0][i][j - 1] + dp[2][i][j - 1]
            
            # 세로 파이프: 세로방향에서 오는 경우 + 대각선 방향에서 오는 경우
            dp[1][i][j] = dp[1][i - 1][j] + dp[2][i - 1][j]
            

print(dp[0][n - 1][n - 1] + dp[1][n - 1][n - 1] + dp[2][n - 1][n - 1])