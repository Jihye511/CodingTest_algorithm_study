import sys

N = int(sys.stdin.readline())

end = 0
answer = 0

arr = []

for _ in range(N):
    a, b = map(int, sys.stdin.readline().split())
    arr.append([a, b])

arr.sort(key=lambda x: (x[1], x[0]))

for newStart, newEnd in arr:
    if end <= newStart:
        answer += 1
        endPoint = newEnd

print(answer)