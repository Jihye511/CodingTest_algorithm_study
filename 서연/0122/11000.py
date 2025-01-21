import sys, heapq

n = int(sys.stdin.readline())
lst = []
for _ in range(n):
    s, e = map(int, sys.stdin.readline().split())
    lst.append((s, e))

lst.sort(key=lambda x: (x[0], x[1]))

heap = [lst[0][1]]
for i in range(1, n):
    if heap[0] <= lst[i][0]:
        heapq.heappop(heap)
    heapq.heappush(heap,lst[i][1])

print(len(heap))