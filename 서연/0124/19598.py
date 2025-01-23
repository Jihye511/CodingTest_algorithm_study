#### 백준 11000(25.01.22)문제와 동일
import sys, heapq

n = int(sys.stdin.readline())
arr = []
for _ in range(n):
    s, e = map(int, sys.stdin.readline().split())
    arr.append((s, e))

arr.sort(key=lambda x: (x[0], x[1]))

result = [arr[0][1]] # 제일 빨리 시작하는 회의의 끝나는 시간

for i in range(1, n):
    if arr[i][0] >= result[0]: # 시작 시간이 끝나는 시간보다 크거나 같으면
        heapq.heappop(result) # 끝나는 시간이 가장 빠른 회의를 제거
    heapq.heappush(result, arr[i][1])

print(len(result))
