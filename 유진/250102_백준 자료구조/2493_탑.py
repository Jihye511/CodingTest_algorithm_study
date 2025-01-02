import sys

N = int(sys.stdin.readline())

top = list(map(int, sys.stdin.readline().strip().split()))

answer = [0] * N

stack = []  # 이전 탑의 위치 저장

for i in range(N):
    while stack and top[stack[-1]] < top[i]:
        stack.pop()

    if stack:
        answer[i] = stack[-1] + 1

    stack.append(i)

print(*answer)
