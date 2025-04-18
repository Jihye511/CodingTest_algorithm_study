import sys

# 해석 비용 함수
def check(w1, w2, l):
    cnt = 0
    for i in range(l):
        if w1[i] != w2[i]:
            cnt += 1
    return cnt

# 입력 받기
s = " " + sys.stdin.readline().strip()
n = int(sys.stdin.readline())
words = [sys.stdin.readline().strip() for _ in range(n)]

INF = len(s) + 1
dp = [INF] * len(s)
dp[0] = 0  # 시작 지점
# dp[i] => s[1:i]까지 해석했을 때의 최소 비용

for i in range(1, len(s)): # 1 ~ len(s)-1
    if dp[i-1] == INF:
        continue  # i-1까지 해석 못하면 패스

    # 단어 리스트를 돌면서 해석 가능한 단어인지 확인
    for word in words:
        end = i + len(word) - 1
        if end >= len(s):
            continue

        segment = s[i:end+1]
        if sorted(segment) == sorted(word):
            cost = check(segment, word, len(word))
            dp[end] = min(dp[end], dp[i-1] + cost) # 갱신

# 출력
print(dp[-1] if dp[-1] != INF else -1)
