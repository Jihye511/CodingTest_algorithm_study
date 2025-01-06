import heapq
import sys
from collections import defaultdict

minHeap = []
maxHeap = []
solved = defaultdict(int)

n = int(sys.stdin.readline())
for _ in range(n):
    p, level = map(int, sys.stdin.readline().split())
    heapq.heappush(minHeap, (level, p))
    heapq.heappush(maxHeap, (-level, -p))

m = int(sys.stdin.readline())
for _ in range(m):
    inputs = sys.stdin.readline().split()
    
    if inputs[0] == 'add':
        p = int(inputs[1])
        level = int(inputs[2])
        heapq.heappush(minHeap, (level, p))
        heapq.heappush(maxHeap, (-level, -p))
    
    elif inputs[0] == 'recommend':    
        if inputs[1] == '1': # 어려운 문제 추천
            while solved[abs(maxHeap[0][1])] != 0:
                solved[abs(maxHeap[0][1])] -= 1
                heapq.heappop(maxHeap)
            print(-maxHeap[0][1])
        
        else: # 쉬운 문제 추천
            while solved[minHeap[0][1]] != 0:
                solved[minHeap[0][1]] -= 1
                heapq.heappop(minHeap)
            print(minHeap[0][1])
    
    elif inputs[0] == 'solved':
        solved[int(inputs[1])] = 1