import sys
import heapq

N = int(sys.stdin.readline())
arr =[]

for _ in range(N):
    s, t = map(int, sys.stdin.readline().split())
    arr.append([s,t])


arr.sort(key=lambda x: (x[0], x[1]))  # 시작 시간, 종료 시간 모두 고려
rooms = [arr[0][1]] #  첫 수업 종료시간

for i in range(1, N):
    if arr[i][0] >= rooms[0]:
        heapq.heapreplace(rooms, arr[i][1])
    else:
        heapq.heappush(rooms, arr[i][1])

print(len(rooms))

