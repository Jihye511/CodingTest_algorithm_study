import sys
import heapq as hp

N = int(sys.stdin.readline())
time = []

for _ in range(N):
    s, e = map(int, sys.stdin.readline().split())
    time.append([s, e])

time.sort()

room = 1
ing = [0]
for start, end in time:
    if start >= ing[0]:
        hp.heappop(ing)
    else:
        room += 1
    hp.heappush(ing, end)

print(room)