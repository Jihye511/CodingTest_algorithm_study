import sys

input = sys.stdin.readline
N = int(input())

circles_point = []

# 원들이 서로 겹치는지 확인
stack = []
for i in range(N):
    x, r = map(int, input().split())
    circles_point.append((x - r, i, 0))  # 원의 시작점
    circles_point.append((x + r, i, 1))  # 원의 끝점

circles_point.sort()

for point in circles_point:
    x, close, open = point
    if open == 0:  # 원 시작지점
        stack.append(point)
    else:  # 원 끝지점
        if stack[-1][1] != close:  # 스택의 마지막 원과 번호가 다르면 겹치는 것
            print("NO")
            exit(0)
        stack.pop()
print("YES")